package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_324")
data class Entity324(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity324Repository : org.springframework.data.jpa.repository.JpaRepository<Entity324, Long> {
    fun findByField1(field1: String): List<Entity324>
    fun findByField3GreaterThan(value: Int): List<Entity324>
}

@Service
@Transactional
class Service324(private val repo: Entity324Repository) {
    fun findAll(): List<Entity324> = repo.findAll()
    fun findByName(name: String): List<Entity324> = repo.findByField1(name)
    fun save(entity: Entity324): Entity324 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity324>): List<Entity324> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
