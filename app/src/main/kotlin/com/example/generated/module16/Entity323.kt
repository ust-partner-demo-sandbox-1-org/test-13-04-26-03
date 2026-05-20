package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_323")
data class Entity323(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity323Repository : org.springframework.data.jpa.repository.JpaRepository<Entity323, Long> {
    fun findByField1(field1: String): List<Entity323>
    fun findByField3GreaterThan(value: Int): List<Entity323>
}

@Service
@Transactional
class Service323(private val repo: Entity323Repository) {
    fun findAll(): List<Entity323> = repo.findAll()
    fun findByName(name: String): List<Entity323> = repo.findByField1(name)
    fun save(entity: Entity323): Entity323 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity323>): List<Entity323> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
