package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_40")
data class Entity40(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity40Repository : org.springframework.data.jpa.repository.JpaRepository<Entity40, Long> {
    fun findByField1(field1: String): List<Entity40>
    fun findByField3GreaterThan(value: Int): List<Entity40>
}

@Service
@Transactional
class Service40(private val repo: Entity40Repository) {
    fun findAll(): List<Entity40> = repo.findAll()
    fun findByName(name: String): List<Entity40> = repo.findByField1(name)
    fun save(entity: Entity40): Entity40 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity40>): List<Entity40> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
