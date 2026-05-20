package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_533")
data class Entity533(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity533Repository : org.springframework.data.jpa.repository.JpaRepository<Entity533, Long> {
    fun findByField1(field1: String): List<Entity533>
    fun findByField3GreaterThan(value: Int): List<Entity533>
}

@Service
@Transactional
class Service533(private val repo: Entity533Repository) {
    fun findAll(): List<Entity533> = repo.findAll()
    fun findByName(name: String): List<Entity533> = repo.findByField1(name)
    fun save(entity: Entity533): Entity533 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity533>): List<Entity533> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
