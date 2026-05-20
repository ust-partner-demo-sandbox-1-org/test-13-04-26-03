package com.example.generated.module21

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_435")
data class Entity435(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity435Repository : org.springframework.data.jpa.repository.JpaRepository<Entity435, Long> {
    fun findByField1(field1: String): List<Entity435>
    fun findByField3GreaterThan(value: Int): List<Entity435>
}

@Service
@Transactional
class Service435(private val repo: Entity435Repository) {
    fun findAll(): List<Entity435> = repo.findAll()
    fun findByName(name: String): List<Entity435> = repo.findByField1(name)
    fun save(entity: Entity435): Entity435 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity435>): List<Entity435> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
