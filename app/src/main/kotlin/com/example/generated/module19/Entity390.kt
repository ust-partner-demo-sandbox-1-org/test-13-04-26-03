package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_390")
data class Entity390(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity390Repository : org.springframework.data.jpa.repository.JpaRepository<Entity390, Long> {
    fun findByField1(field1: String): List<Entity390>
    fun findByField3GreaterThan(value: Int): List<Entity390>
}

@Service
@Transactional
class Service390(private val repo: Entity390Repository) {
    fun findAll(): List<Entity390> = repo.findAll()
    fun findByName(name: String): List<Entity390> = repo.findByField1(name)
    fun save(entity: Entity390): Entity390 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity390>): List<Entity390> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
