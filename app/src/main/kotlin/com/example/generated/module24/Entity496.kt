package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_496")
data class Entity496(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity496Repository : org.springframework.data.jpa.repository.JpaRepository<Entity496, Long> {
    fun findByField1(field1: String): List<Entity496>
    fun findByField3GreaterThan(value: Int): List<Entity496>
}

@Service
@Transactional
class Service496(private val repo: Entity496Repository) {
    fun findAll(): List<Entity496> = repo.findAll()
    fun findByName(name: String): List<Entity496> = repo.findByField1(name)
    fun save(entity: Entity496): Entity496 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity496>): List<Entity496> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
