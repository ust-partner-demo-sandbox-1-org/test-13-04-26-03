package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_617")
data class Entity617(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity617Repository : org.springframework.data.jpa.repository.JpaRepository<Entity617, Long> {
    fun findByField1(field1: String): List<Entity617>
    fun findByField3GreaterThan(value: Int): List<Entity617>
}

@Service
@Transactional
class Service617(private val repo: Entity617Repository) {
    fun findAll(): List<Entity617> = repo.findAll()
    fun findByName(name: String): List<Entity617> = repo.findByField1(name)
    fun save(entity: Entity617): Entity617 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity617>): List<Entity617> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
