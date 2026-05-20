package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_539")
data class Entity539(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity539Repository : org.springframework.data.jpa.repository.JpaRepository<Entity539, Long> {
    fun findByField1(field1: String): List<Entity539>
    fun findByField3GreaterThan(value: Int): List<Entity539>
}

@Service
@Transactional
class Service539(private val repo: Entity539Repository) {
    fun findAll(): List<Entity539> = repo.findAll()
    fun findByName(name: String): List<Entity539> = repo.findByField1(name)
    fun save(entity: Entity539): Entity539 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity539>): List<Entity539> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
