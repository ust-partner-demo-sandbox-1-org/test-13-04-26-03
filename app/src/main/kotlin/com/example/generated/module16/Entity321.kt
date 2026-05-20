package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_321")
data class Entity321(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity321Repository : org.springframework.data.jpa.repository.JpaRepository<Entity321, Long> {
    fun findByField1(field1: String): List<Entity321>
    fun findByField3GreaterThan(value: Int): List<Entity321>
}

@Service
@Transactional
class Service321(private val repo: Entity321Repository) {
    fun findAll(): List<Entity321> = repo.findAll()
    fun findByName(name: String): List<Entity321> = repo.findByField1(name)
    fun save(entity: Entity321): Entity321 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity321>): List<Entity321> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
