package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_494")
data class Entity494(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity494Repository : org.springframework.data.jpa.repository.JpaRepository<Entity494, Long> {
    fun findByField1(field1: String): List<Entity494>
    fun findByField3GreaterThan(value: Int): List<Entity494>
}

@Service
@Transactional
class Service494(private val repo: Entity494Repository) {
    fun findAll(): List<Entity494> = repo.findAll()
    fun findByName(name: String): List<Entity494> = repo.findByField1(name)
    fun save(entity: Entity494): Entity494 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity494>): List<Entity494> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
