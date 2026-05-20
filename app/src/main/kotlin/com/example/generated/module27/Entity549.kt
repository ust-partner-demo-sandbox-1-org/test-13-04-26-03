package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_549")
data class Entity549(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity549Repository : org.springframework.data.jpa.repository.JpaRepository<Entity549, Long> {
    fun findByField1(field1: String): List<Entity549>
    fun findByField3GreaterThan(value: Int): List<Entity549>
}

@Service
@Transactional
class Service549(private val repo: Entity549Repository) {
    fun findAll(): List<Entity549> = repo.findAll()
    fun findByName(name: String): List<Entity549> = repo.findByField1(name)
    fun save(entity: Entity549): Entity549 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity549>): List<Entity549> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
