package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_623")
data class Entity623(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity623Repository : org.springframework.data.jpa.repository.JpaRepository<Entity623, Long> {
    fun findByField1(field1: String): List<Entity623>
    fun findByField3GreaterThan(value: Int): List<Entity623>
}

@Service
@Transactional
class Service623(private val repo: Entity623Repository) {
    fun findAll(): List<Entity623> = repo.findAll()
    fun findByName(name: String): List<Entity623> = repo.findByField1(name)
    fun save(entity: Entity623): Entity623 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity623>): List<Entity623> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
