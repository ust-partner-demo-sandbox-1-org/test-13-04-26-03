package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_200")
data class Entity200(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity200Repository : org.springframework.data.jpa.repository.JpaRepository<Entity200, Long> {
    fun findByField1(field1: String): List<Entity200>
    fun findByField3GreaterThan(value: Int): List<Entity200>
}

@Service
@Transactional
class Service200(private val repo: Entity200Repository) {
    fun findAll(): List<Entity200> = repo.findAll()
    fun findByName(name: String): List<Entity200> = repo.findByField1(name)
    fun save(entity: Entity200): Entity200 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity200>): List<Entity200> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
