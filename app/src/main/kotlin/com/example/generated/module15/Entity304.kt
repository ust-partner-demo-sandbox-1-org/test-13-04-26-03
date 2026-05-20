package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_304")
data class Entity304(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity304Repository : org.springframework.data.jpa.repository.JpaRepository<Entity304, Long> {
    fun findByField1(field1: String): List<Entity304>
    fun findByField3GreaterThan(value: Int): List<Entity304>
}

@Service
@Transactional
class Service304(private val repo: Entity304Repository) {
    fun findAll(): List<Entity304> = repo.findAll()
    fun findByName(name: String): List<Entity304> = repo.findByField1(name)
    fun save(entity: Entity304): Entity304 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity304>): List<Entity304> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
