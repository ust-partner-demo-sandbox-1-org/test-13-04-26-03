package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_157")
data class Entity157(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity157Repository : org.springframework.data.jpa.repository.JpaRepository<Entity157, Long> {
    fun findByField1(field1: String): List<Entity157>
    fun findByField3GreaterThan(value: Int): List<Entity157>
}

@Service
@Transactional
class Service157(private val repo: Entity157Repository) {
    fun findAll(): List<Entity157> = repo.findAll()
    fun findByName(name: String): List<Entity157> = repo.findByField1(name)
    fun save(entity: Entity157): Entity157 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity157>): List<Entity157> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
