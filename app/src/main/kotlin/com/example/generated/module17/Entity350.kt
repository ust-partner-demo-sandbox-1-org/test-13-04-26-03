package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_350")
data class Entity350(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity350Repository : org.springframework.data.jpa.repository.JpaRepository<Entity350, Long> {
    fun findByField1(field1: String): List<Entity350>
    fun findByField3GreaterThan(value: Int): List<Entity350>
}

@Service
@Transactional
class Service350(private val repo: Entity350Repository) {
    fun findAll(): List<Entity350> = repo.findAll()
    fun findByName(name: String): List<Entity350> = repo.findByField1(name)
    fun save(entity: Entity350): Entity350 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity350>): List<Entity350> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
