package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_585")
data class Entity585(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity585Repository : org.springframework.data.jpa.repository.JpaRepository<Entity585, Long> {
    fun findByField1(field1: String): List<Entity585>
    fun findByField3GreaterThan(value: Int): List<Entity585>
}

@Service
@Transactional
class Service585(private val repo: Entity585Repository) {
    fun findAll(): List<Entity585> = repo.findAll()
    fun findByName(name: String): List<Entity585> = repo.findByField1(name)
    fun save(entity: Entity585): Entity585 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity585>): List<Entity585> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
