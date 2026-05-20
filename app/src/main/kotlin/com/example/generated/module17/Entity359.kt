package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_359")
data class Entity359(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity359Repository : org.springframework.data.jpa.repository.JpaRepository<Entity359, Long> {
    fun findByField1(field1: String): List<Entity359>
    fun findByField3GreaterThan(value: Int): List<Entity359>
}

@Service
@Transactional
class Service359(private val repo: Entity359Repository) {
    fun findAll(): List<Entity359> = repo.findAll()
    fun findByName(name: String): List<Entity359> = repo.findByField1(name)
    fun save(entity: Entity359): Entity359 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity359>): List<Entity359> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
