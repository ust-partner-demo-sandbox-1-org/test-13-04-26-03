package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_419")
data class Entity419(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity419Repository : org.springframework.data.jpa.repository.JpaRepository<Entity419, Long> {
    fun findByField1(field1: String): List<Entity419>
    fun findByField3GreaterThan(value: Int): List<Entity419>
}

@Service
@Transactional
class Service419(private val repo: Entity419Repository) {
    fun findAll(): List<Entity419> = repo.findAll()
    fun findByName(name: String): List<Entity419> = repo.findByField1(name)
    fun save(entity: Entity419): Entity419 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity419>): List<Entity419> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
