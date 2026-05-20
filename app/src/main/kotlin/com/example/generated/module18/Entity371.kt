package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_371")
data class Entity371(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity371Repository : org.springframework.data.jpa.repository.JpaRepository<Entity371, Long> {
    fun findByField1(field1: String): List<Entity371>
    fun findByField3GreaterThan(value: Int): List<Entity371>
}

@Service
@Transactional
class Service371(private val repo: Entity371Repository) {
    fun findAll(): List<Entity371> = repo.findAll()
    fun findByName(name: String): List<Entity371> = repo.findByField1(name)
    fun save(entity: Entity371): Entity371 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity371>): List<Entity371> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
