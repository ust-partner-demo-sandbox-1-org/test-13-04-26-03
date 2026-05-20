package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_903")
data class Entity903(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity903Repository : org.springframework.data.jpa.repository.JpaRepository<Entity903, Long> {
    fun findByField1(field1: String): List<Entity903>
    fun findByField3GreaterThan(value: Int): List<Entity903>
}

@Service
@Transactional
class Service903(private val repo: Entity903Repository) {
    fun findAll(): List<Entity903> = repo.findAll()
    fun findByName(name: String): List<Entity903> = repo.findByField1(name)
    fun save(entity: Entity903): Entity903 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity903>): List<Entity903> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
