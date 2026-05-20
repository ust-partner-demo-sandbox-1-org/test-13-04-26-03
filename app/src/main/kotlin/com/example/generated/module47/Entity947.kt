package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_947")
data class Entity947(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity947Repository : org.springframework.data.jpa.repository.JpaRepository<Entity947, Long> {
    fun findByField1(field1: String): List<Entity947>
    fun findByField3GreaterThan(value: Int): List<Entity947>
}

@Service
@Transactional
class Service947(private val repo: Entity947Repository) {
    fun findAll(): List<Entity947> = repo.findAll()
    fun findByName(name: String): List<Entity947> = repo.findByField1(name)
    fun save(entity: Entity947): Entity947 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity947>): List<Entity947> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
