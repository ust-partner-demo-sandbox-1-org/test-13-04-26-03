package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_70")
data class Entity70(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity70Repository : org.springframework.data.jpa.repository.JpaRepository<Entity70, Long> {
    fun findByField1(field1: String): List<Entity70>
    fun findByField3GreaterThan(value: Int): List<Entity70>
}

@Service
@Transactional
class Service70(private val repo: Entity70Repository) {
    fun findAll(): List<Entity70> = repo.findAll()
    fun findByName(name: String): List<Entity70> = repo.findByField1(name)
    fun save(entity: Entity70): Entity70 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity70>): List<Entity70> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
