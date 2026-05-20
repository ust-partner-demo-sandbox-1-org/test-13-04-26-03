package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_570")
data class Entity570(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity570Repository : org.springframework.data.jpa.repository.JpaRepository<Entity570, Long> {
    fun findByField1(field1: String): List<Entity570>
    fun findByField3GreaterThan(value: Int): List<Entity570>
}

@Service
@Transactional
class Service570(private val repo: Entity570Repository) {
    fun findAll(): List<Entity570> = repo.findAll()
    fun findByName(name: String): List<Entity570> = repo.findByField1(name)
    fun save(entity: Entity570): Entity570 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity570>): List<Entity570> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
