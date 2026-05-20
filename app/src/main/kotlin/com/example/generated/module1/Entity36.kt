package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_36")
data class Entity36(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity36Repository : org.springframework.data.jpa.repository.JpaRepository<Entity36, Long> {
    fun findByField1(field1: String): List<Entity36>
    fun findByField3GreaterThan(value: Int): List<Entity36>
}

@Service
@Transactional
class Service36(private val repo: Entity36Repository) {
    fun findAll(): List<Entity36> = repo.findAll()
    fun findByName(name: String): List<Entity36> = repo.findByField1(name)
    fun save(entity: Entity36): Entity36 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity36>): List<Entity36> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
