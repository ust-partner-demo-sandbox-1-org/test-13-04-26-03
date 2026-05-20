package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_340")
data class Entity340(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity340Repository : org.springframework.data.jpa.repository.JpaRepository<Entity340, Long> {
    fun findByField1(field1: String): List<Entity340>
    fun findByField3GreaterThan(value: Int): List<Entity340>
}

@Service
@Transactional
class Service340(private val repo: Entity340Repository) {
    fun findAll(): List<Entity340> = repo.findAll()
    fun findByName(name: String): List<Entity340> = repo.findByField1(name)
    fun save(entity: Entity340): Entity340 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity340>): List<Entity340> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
