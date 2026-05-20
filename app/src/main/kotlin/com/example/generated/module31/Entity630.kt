package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_630")
data class Entity630(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity630Repository : org.springframework.data.jpa.repository.JpaRepository<Entity630, Long> {
    fun findByField1(field1: String): List<Entity630>
    fun findByField3GreaterThan(value: Int): List<Entity630>
}

@Service
@Transactional
class Service630(private val repo: Entity630Repository) {
    fun findAll(): List<Entity630> = repo.findAll()
    fun findByName(name: String): List<Entity630> = repo.findByField1(name)
    fun save(entity: Entity630): Entity630 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity630>): List<Entity630> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
