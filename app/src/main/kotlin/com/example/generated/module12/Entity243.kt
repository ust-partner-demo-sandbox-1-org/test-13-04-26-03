package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_243")
data class Entity243(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity243Repository : org.springframework.data.jpa.repository.JpaRepository<Entity243, Long> {
    fun findByField1(field1: String): List<Entity243>
    fun findByField3GreaterThan(value: Int): List<Entity243>
}

@Service
@Transactional
class Service243(private val repo: Entity243Repository) {
    fun findAll(): List<Entity243> = repo.findAll()
    fun findByName(name: String): List<Entity243> = repo.findByField1(name)
    fun save(entity: Entity243): Entity243 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity243>): List<Entity243> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
