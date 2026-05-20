package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_731")
data class Entity731(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity731Repository : org.springframework.data.jpa.repository.JpaRepository<Entity731, Long> {
    fun findByField1(field1: String): List<Entity731>
    fun findByField3GreaterThan(value: Int): List<Entity731>
}

@Service
@Transactional
class Service731(private val repo: Entity731Repository) {
    fun findAll(): List<Entity731> = repo.findAll()
    fun findByName(name: String): List<Entity731> = repo.findByField1(name)
    fun save(entity: Entity731): Entity731 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity731>): List<Entity731> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
