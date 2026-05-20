package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_51")
data class Entity51(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity51Repository : org.springframework.data.jpa.repository.JpaRepository<Entity51, Long> {
    fun findByField1(field1: String): List<Entity51>
    fun findByField3GreaterThan(value: Int): List<Entity51>
}

@Service
@Transactional
class Service51(private val repo: Entity51Repository) {
    fun findAll(): List<Entity51> = repo.findAll()
    fun findByName(name: String): List<Entity51> = repo.findByField1(name)
    fun save(entity: Entity51): Entity51 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity51>): List<Entity51> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
