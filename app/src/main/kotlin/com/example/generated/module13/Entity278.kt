package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_278")
data class Entity278(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity278Repository : org.springframework.data.jpa.repository.JpaRepository<Entity278, Long> {
    fun findByField1(field1: String): List<Entity278>
    fun findByField3GreaterThan(value: Int): List<Entity278>
}

@Service
@Transactional
class Service278(private val repo: Entity278Repository) {
    fun findAll(): List<Entity278> = repo.findAll()
    fun findByName(name: String): List<Entity278> = repo.findByField1(name)
    fun save(entity: Entity278): Entity278 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity278>): List<Entity278> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
