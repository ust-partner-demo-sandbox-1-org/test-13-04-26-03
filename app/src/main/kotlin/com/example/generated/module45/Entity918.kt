package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_918")
data class Entity918(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity918Repository : org.springframework.data.jpa.repository.JpaRepository<Entity918, Long> {
    fun findByField1(field1: String): List<Entity918>
    fun findByField3GreaterThan(value: Int): List<Entity918>
}

@Service
@Transactional
class Service918(private val repo: Entity918Repository) {
    fun findAll(): List<Entity918> = repo.findAll()
    fun findByName(name: String): List<Entity918> = repo.findByField1(name)
    fun save(entity: Entity918): Entity918 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity918>): List<Entity918> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
