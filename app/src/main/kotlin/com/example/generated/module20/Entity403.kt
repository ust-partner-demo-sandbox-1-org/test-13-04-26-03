package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_403")
data class Entity403(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity403Repository : org.springframework.data.jpa.repository.JpaRepository<Entity403, Long> {
    fun findByField1(field1: String): List<Entity403>
    fun findByField3GreaterThan(value: Int): List<Entity403>
}

@Service
@Transactional
class Service403(private val repo: Entity403Repository) {
    fun findAll(): List<Entity403> = repo.findAll()
    fun findByName(name: String): List<Entity403> = repo.findByField1(name)
    fun save(entity: Entity403): Entity403 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity403>): List<Entity403> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
