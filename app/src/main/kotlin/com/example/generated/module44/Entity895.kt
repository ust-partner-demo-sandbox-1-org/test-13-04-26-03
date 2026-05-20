package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_895")
data class Entity895(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity895Repository : org.springframework.data.jpa.repository.JpaRepository<Entity895, Long> {
    fun findByField1(field1: String): List<Entity895>
    fun findByField3GreaterThan(value: Int): List<Entity895>
}

@Service
@Transactional
class Service895(private val repo: Entity895Repository) {
    fun findAll(): List<Entity895> = repo.findAll()
    fun findByName(name: String): List<Entity895> = repo.findByField1(name)
    fun save(entity: Entity895): Entity895 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity895>): List<Entity895> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
