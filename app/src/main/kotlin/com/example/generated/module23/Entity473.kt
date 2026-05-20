package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_473")
data class Entity473(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity473Repository : org.springframework.data.jpa.repository.JpaRepository<Entity473, Long> {
    fun findByField1(field1: String): List<Entity473>
    fun findByField3GreaterThan(value: Int): List<Entity473>
}

@Service
@Transactional
class Service473(private val repo: Entity473Repository) {
    fun findAll(): List<Entity473> = repo.findAll()
    fun findByName(name: String): List<Entity473> = repo.findByField1(name)
    fun save(entity: Entity473): Entity473 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity473>): List<Entity473> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
