package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_467")
data class Entity467(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity467Repository : org.springframework.data.jpa.repository.JpaRepository<Entity467, Long> {
    fun findByField1(field1: String): List<Entity467>
    fun findByField3GreaterThan(value: Int): List<Entity467>
}

@Service
@Transactional
class Service467(private val repo: Entity467Repository) {
    fun findAll(): List<Entity467> = repo.findAll()
    fun findByName(name: String): List<Entity467> = repo.findByField1(name)
    fun save(entity: Entity467): Entity467 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity467>): List<Entity467> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
