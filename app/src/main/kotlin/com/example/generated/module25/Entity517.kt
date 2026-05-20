package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_517")
data class Entity517(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity517Repository : org.springframework.data.jpa.repository.JpaRepository<Entity517, Long> {
    fun findByField1(field1: String): List<Entity517>
    fun findByField3GreaterThan(value: Int): List<Entity517>
}

@Service
@Transactional
class Service517(private val repo: Entity517Repository) {
    fun findAll(): List<Entity517> = repo.findAll()
    fun findByName(name: String): List<Entity517> = repo.findByField1(name)
    fun save(entity: Entity517): Entity517 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity517>): List<Entity517> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
