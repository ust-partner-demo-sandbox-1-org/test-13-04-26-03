package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_54")
data class Entity54(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity54Repository : org.springframework.data.jpa.repository.JpaRepository<Entity54, Long> {
    fun findByField1(field1: String): List<Entity54>
    fun findByField3GreaterThan(value: Int): List<Entity54>
}

@Service
@Transactional
class Service54(private val repo: Entity54Repository) {
    fun findAll(): List<Entity54> = repo.findAll()
    fun findByName(name: String): List<Entity54> = repo.findByField1(name)
    fun save(entity: Entity54): Entity54 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity54>): List<Entity54> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
