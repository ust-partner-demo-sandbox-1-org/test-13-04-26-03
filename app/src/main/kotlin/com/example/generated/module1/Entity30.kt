package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_30")
data class Entity30(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity30Repository : org.springframework.data.jpa.repository.JpaRepository<Entity30, Long> {
    fun findByField1(field1: String): List<Entity30>
    fun findByField3GreaterThan(value: Int): List<Entity30>
}

@Service
@Transactional
class Service30(private val repo: Entity30Repository) {
    fun findAll(): List<Entity30> = repo.findAll()
    fun findByName(name: String): List<Entity30> = repo.findByField1(name)
    fun save(entity: Entity30): Entity30 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity30>): List<Entity30> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
