package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_514")
data class Entity514(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity514Repository : org.springframework.data.jpa.repository.JpaRepository<Entity514, Long> {
    fun findByField1(field1: String): List<Entity514>
    fun findByField3GreaterThan(value: Int): List<Entity514>
}

@Service
@Transactional
class Service514(private val repo: Entity514Repository) {
    fun findAll(): List<Entity514> = repo.findAll()
    fun findByName(name: String): List<Entity514> = repo.findByField1(name)
    fun save(entity: Entity514): Entity514 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity514>): List<Entity514> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
