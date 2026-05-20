package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_974")
data class Entity974(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity974Repository : org.springframework.data.jpa.repository.JpaRepository<Entity974, Long> {
    fun findByField1(field1: String): List<Entity974>
    fun findByField3GreaterThan(value: Int): List<Entity974>
}

@Service
@Transactional
class Service974(private val repo: Entity974Repository) {
    fun findAll(): List<Entity974> = repo.findAll()
    fun findByName(name: String): List<Entity974> = repo.findByField1(name)
    fun save(entity: Entity974): Entity974 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity974>): List<Entity974> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
