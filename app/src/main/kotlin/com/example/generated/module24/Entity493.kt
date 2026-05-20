package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_493")
data class Entity493(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity493Repository : org.springframework.data.jpa.repository.JpaRepository<Entity493, Long> {
    fun findByField1(field1: String): List<Entity493>
    fun findByField3GreaterThan(value: Int): List<Entity493>
}

@Service
@Transactional
class Service493(private val repo: Entity493Repository) {
    fun findAll(): List<Entity493> = repo.findAll()
    fun findByName(name: String): List<Entity493> = repo.findByField1(name)
    fun save(entity: Entity493): Entity493 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity493>): List<Entity493> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
