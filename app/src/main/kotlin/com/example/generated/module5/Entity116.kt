package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_116")
data class Entity116(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity116Repository : org.springframework.data.jpa.repository.JpaRepository<Entity116, Long> {
    fun findByField1(field1: String): List<Entity116>
    fun findByField3GreaterThan(value: Int): List<Entity116>
}

@Service
@Transactional
class Service116(private val repo: Entity116Repository) {
    fun findAll(): List<Entity116> = repo.findAll()
    fun findByName(name: String): List<Entity116> = repo.findByField1(name)
    fun save(entity: Entity116): Entity116 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity116>): List<Entity116> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
