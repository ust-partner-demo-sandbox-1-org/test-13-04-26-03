package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_722")
data class Entity722(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity722Repository : org.springframework.data.jpa.repository.JpaRepository<Entity722, Long> {
    fun findByField1(field1: String): List<Entity722>
    fun findByField3GreaterThan(value: Int): List<Entity722>
}

@Service
@Transactional
class Service722(private val repo: Entity722Repository) {
    fun findAll(): List<Entity722> = repo.findAll()
    fun findByName(name: String): List<Entity722> = repo.findByField1(name)
    fun save(entity: Entity722): Entity722 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity722>): List<Entity722> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
