package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_60")
data class Entity60(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity60Repository : org.springframework.data.jpa.repository.JpaRepository<Entity60, Long> {
    fun findByField1(field1: String): List<Entity60>
    fun findByField3GreaterThan(value: Int): List<Entity60>
}

@Service
@Transactional
class Service60(private val repo: Entity60Repository) {
    fun findAll(): List<Entity60> = repo.findAll()
    fun findByName(name: String): List<Entity60> = repo.findByField1(name)
    fun save(entity: Entity60): Entity60 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity60>): List<Entity60> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
