package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_509")
data class Entity509(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity509Repository : org.springframework.data.jpa.repository.JpaRepository<Entity509, Long> {
    fun findByField1(field1: String): List<Entity509>
    fun findByField3GreaterThan(value: Int): List<Entity509>
}

@Service
@Transactional
class Service509(private val repo: Entity509Repository) {
    fun findAll(): List<Entity509> = repo.findAll()
    fun findByName(name: String): List<Entity509> = repo.findByField1(name)
    fun save(entity: Entity509): Entity509 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity509>): List<Entity509> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
