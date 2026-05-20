package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_843")
data class Entity843(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity843Repository : org.springframework.data.jpa.repository.JpaRepository<Entity843, Long> {
    fun findByField1(field1: String): List<Entity843>
    fun findByField3GreaterThan(value: Int): List<Entity843>
}

@Service
@Transactional
class Service843(private val repo: Entity843Repository) {
    fun findAll(): List<Entity843> = repo.findAll()
    fun findByName(name: String): List<Entity843> = repo.findByField1(name)
    fun save(entity: Entity843): Entity843 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity843>): List<Entity843> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
