package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_588")
data class Entity588(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity588Repository : org.springframework.data.jpa.repository.JpaRepository<Entity588, Long> {
    fun findByField1(field1: String): List<Entity588>
    fun findByField3GreaterThan(value: Int): List<Entity588>
}

@Service
@Transactional
class Service588(private val repo: Entity588Repository) {
    fun findAll(): List<Entity588> = repo.findAll()
    fun findByName(name: String): List<Entity588> = repo.findByField1(name)
    fun save(entity: Entity588): Entity588 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity588>): List<Entity588> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
