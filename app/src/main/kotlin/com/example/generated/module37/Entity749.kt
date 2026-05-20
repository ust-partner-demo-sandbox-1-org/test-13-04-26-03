package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_749")
data class Entity749(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity749Repository : org.springframework.data.jpa.repository.JpaRepository<Entity749, Long> {
    fun findByField1(field1: String): List<Entity749>
    fun findByField3GreaterThan(value: Int): List<Entity749>
}

@Service
@Transactional
class Service749(private val repo: Entity749Repository) {
    fun findAll(): List<Entity749> = repo.findAll()
    fun findByName(name: String): List<Entity749> = repo.findByField1(name)
    fun save(entity: Entity749): Entity749 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity749>): List<Entity749> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
