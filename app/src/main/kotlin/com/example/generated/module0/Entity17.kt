package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_17")
data class Entity17(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity17Repository : org.springframework.data.jpa.repository.JpaRepository<Entity17, Long> {
    fun findByField1(field1: String): List<Entity17>
    fun findByField3GreaterThan(value: Int): List<Entity17>
}

@Service
@Transactional
class Service17(private val repo: Entity17Repository) {
    fun findAll(): List<Entity17> = repo.findAll()
    fun findByName(name: String): List<Entity17> = repo.findByField1(name)
    fun save(entity: Entity17): Entity17 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity17>): List<Entity17> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
