package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_139")
data class Entity139(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity139Repository : org.springframework.data.jpa.repository.JpaRepository<Entity139, Long> {
    fun findByField1(field1: String): List<Entity139>
    fun findByField3GreaterThan(value: Int): List<Entity139>
}

@Service
@Transactional
class Service139(private val repo: Entity139Repository) {
    fun findAll(): List<Entity139> = repo.findAll()
    fun findByName(name: String): List<Entity139> = repo.findByField1(name)
    fun save(entity: Entity139): Entity139 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity139>): List<Entity139> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
