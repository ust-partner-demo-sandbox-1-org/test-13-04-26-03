package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_485")
data class Entity485(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity485Repository : org.springframework.data.jpa.repository.JpaRepository<Entity485, Long> {
    fun findByField1(field1: String): List<Entity485>
    fun findByField3GreaterThan(value: Int): List<Entity485>
}

@Service
@Transactional
class Service485(private val repo: Entity485Repository) {
    fun findAll(): List<Entity485> = repo.findAll()
    fun findByName(name: String): List<Entity485> = repo.findByField1(name)
    fun save(entity: Entity485): Entity485 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity485>): List<Entity485> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
