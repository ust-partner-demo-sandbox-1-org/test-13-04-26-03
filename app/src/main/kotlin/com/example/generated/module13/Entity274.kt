package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_274")
data class Entity274(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity274Repository : org.springframework.data.jpa.repository.JpaRepository<Entity274, Long> {
    fun findByField1(field1: String): List<Entity274>
    fun findByField3GreaterThan(value: Int): List<Entity274>
}

@Service
@Transactional
class Service274(private val repo: Entity274Repository) {
    fun findAll(): List<Entity274> = repo.findAll()
    fun findByName(name: String): List<Entity274> = repo.findByField1(name)
    fun save(entity: Entity274): Entity274 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity274>): List<Entity274> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
