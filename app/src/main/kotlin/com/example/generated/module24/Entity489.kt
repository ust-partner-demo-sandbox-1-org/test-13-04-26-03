package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_489")
data class Entity489(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity489Repository : org.springframework.data.jpa.repository.JpaRepository<Entity489, Long> {
    fun findByField1(field1: String): List<Entity489>
    fun findByField3GreaterThan(value: Int): List<Entity489>
}

@Service
@Transactional
class Service489(private val repo: Entity489Repository) {
    fun findAll(): List<Entity489> = repo.findAll()
    fun findByName(name: String): List<Entity489> = repo.findByField1(name)
    fun save(entity: Entity489): Entity489 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity489>): List<Entity489> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
