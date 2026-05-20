package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_785")
data class Entity785(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity785Repository : org.springframework.data.jpa.repository.JpaRepository<Entity785, Long> {
    fun findByField1(field1: String): List<Entity785>
    fun findByField3GreaterThan(value: Int): List<Entity785>
}

@Service
@Transactional
class Service785(private val repo: Entity785Repository) {
    fun findAll(): List<Entity785> = repo.findAll()
    fun findByName(name: String): List<Entity785> = repo.findByField1(name)
    fun save(entity: Entity785): Entity785 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity785>): List<Entity785> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
