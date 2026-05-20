package com.example.generated.module21

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_422")
data class Entity422(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity422Repository : org.springframework.data.jpa.repository.JpaRepository<Entity422, Long> {
    fun findByField1(field1: String): List<Entity422>
    fun findByField3GreaterThan(value: Int): List<Entity422>
}

@Service
@Transactional
class Service422(private val repo: Entity422Repository) {
    fun findAll(): List<Entity422> = repo.findAll()
    fun findByName(name: String): List<Entity422> = repo.findByField1(name)
    fun save(entity: Entity422): Entity422 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity422>): List<Entity422> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
