package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_655")
data class Entity655(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity655Repository : org.springframework.data.jpa.repository.JpaRepository<Entity655, Long> {
    fun findByField1(field1: String): List<Entity655>
    fun findByField3GreaterThan(value: Int): List<Entity655>
}

@Service
@Transactional
class Service655(private val repo: Entity655Repository) {
    fun findAll(): List<Entity655> = repo.findAll()
    fun findByName(name: String): List<Entity655> = repo.findByField1(name)
    fun save(entity: Entity655): Entity655 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity655>): List<Entity655> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
