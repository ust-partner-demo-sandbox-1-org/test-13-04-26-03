package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_582")
data class Entity582(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity582Repository : org.springframework.data.jpa.repository.JpaRepository<Entity582, Long> {
    fun findByField1(field1: String): List<Entity582>
    fun findByField3GreaterThan(value: Int): List<Entity582>
}

@Service
@Transactional
class Service582(private val repo: Entity582Repository) {
    fun findAll(): List<Entity582> = repo.findAll()
    fun findByName(name: String): List<Entity582> = repo.findByField1(name)
    fun save(entity: Entity582): Entity582 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity582>): List<Entity582> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
