package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_96")
data class Entity96(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity96Repository : org.springframework.data.jpa.repository.JpaRepository<Entity96, Long> {
    fun findByField1(field1: String): List<Entity96>
    fun findByField3GreaterThan(value: Int): List<Entity96>
}

@Service
@Transactional
class Service96(private val repo: Entity96Repository) {
    fun findAll(): List<Entity96> = repo.findAll()
    fun findByName(name: String): List<Entity96> = repo.findByField1(name)
    fun save(entity: Entity96): Entity96 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity96>): List<Entity96> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
