package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_986")
data class Entity986(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity986Repository : org.springframework.data.jpa.repository.JpaRepository<Entity986, Long> {
    fun findByField1(field1: String): List<Entity986>
    fun findByField3GreaterThan(value: Int): List<Entity986>
}

@Service
@Transactional
class Service986(private val repo: Entity986Repository) {
    fun findAll(): List<Entity986> = repo.findAll()
    fun findByName(name: String): List<Entity986> = repo.findByField1(name)
    fun save(entity: Entity986): Entity986 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity986>): List<Entity986> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
