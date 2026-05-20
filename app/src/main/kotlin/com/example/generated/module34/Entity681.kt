package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_681")
data class Entity681(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity681Repository : org.springframework.data.jpa.repository.JpaRepository<Entity681, Long> {
    fun findByField1(field1: String): List<Entity681>
    fun findByField3GreaterThan(value: Int): List<Entity681>
}

@Service
@Transactional
class Service681(private val repo: Entity681Repository) {
    fun findAll(): List<Entity681> = repo.findAll()
    fun findByName(name: String): List<Entity681> = repo.findByField1(name)
    fun save(entity: Entity681): Entity681 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity681>): List<Entity681> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
