package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_754")
data class Entity754(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity754Repository : org.springframework.data.jpa.repository.JpaRepository<Entity754, Long> {
    fun findByField1(field1: String): List<Entity754>
    fun findByField3GreaterThan(value: Int): List<Entity754>
}

@Service
@Transactional
class Service754(private val repo: Entity754Repository) {
    fun findAll(): List<Entity754> = repo.findAll()
    fun findByName(name: String): List<Entity754> = repo.findByField1(name)
    fun save(entity: Entity754): Entity754 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity754>): List<Entity754> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
