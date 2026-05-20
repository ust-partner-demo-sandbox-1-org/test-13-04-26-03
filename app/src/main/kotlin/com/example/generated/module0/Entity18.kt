package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_18")
data class Entity18(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity18Repository : org.springframework.data.jpa.repository.JpaRepository<Entity18, Long> {
    fun findByField1(field1: String): List<Entity18>
    fun findByField3GreaterThan(value: Int): List<Entity18>
}

@Service
@Transactional
class Service18(private val repo: Entity18Repository) {
    fun findAll(): List<Entity18> = repo.findAll()
    fun findByName(name: String): List<Entity18> = repo.findByField1(name)
    fun save(entity: Entity18): Entity18 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity18>): List<Entity18> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
