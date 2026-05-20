package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_810")
data class Entity810(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity810Repository : org.springframework.data.jpa.repository.JpaRepository<Entity810, Long> {
    fun findByField1(field1: String): List<Entity810>
    fun findByField3GreaterThan(value: Int): List<Entity810>
}

@Service
@Transactional
class Service810(private val repo: Entity810Repository) {
    fun findAll(): List<Entity810> = repo.findAll()
    fun findByName(name: String): List<Entity810> = repo.findByField1(name)
    fun save(entity: Entity810): Entity810 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity810>): List<Entity810> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
