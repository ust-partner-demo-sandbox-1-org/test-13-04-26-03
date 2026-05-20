package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_524")
data class Entity524(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity524Repository : org.springframework.data.jpa.repository.JpaRepository<Entity524, Long> {
    fun findByField1(field1: String): List<Entity524>
    fun findByField3GreaterThan(value: Int): List<Entity524>
}

@Service
@Transactional
class Service524(private val repo: Entity524Repository) {
    fun findAll(): List<Entity524> = repo.findAll()
    fun findByName(name: String): List<Entity524> = repo.findByField1(name)
    fun save(entity: Entity524): Entity524 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity524>): List<Entity524> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
