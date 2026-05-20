package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_581")
data class Entity581(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity581Repository : org.springframework.data.jpa.repository.JpaRepository<Entity581, Long> {
    fun findByField1(field1: String): List<Entity581>
    fun findByField3GreaterThan(value: Int): List<Entity581>
}

@Service
@Transactional
class Service581(private val repo: Entity581Repository) {
    fun findAll(): List<Entity581> = repo.findAll()
    fun findByName(name: String): List<Entity581> = repo.findByField1(name)
    fun save(entity: Entity581): Entity581 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity581>): List<Entity581> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
