package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_799")
data class Entity799(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity799Repository : org.springframework.data.jpa.repository.JpaRepository<Entity799, Long> {
    fun findByField1(field1: String): List<Entity799>
    fun findByField3GreaterThan(value: Int): List<Entity799>
}

@Service
@Transactional
class Service799(private val repo: Entity799Repository) {
    fun findAll(): List<Entity799> = repo.findAll()
    fun findByName(name: String): List<Entity799> = repo.findByField1(name)
    fun save(entity: Entity799): Entity799 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity799>): List<Entity799> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
