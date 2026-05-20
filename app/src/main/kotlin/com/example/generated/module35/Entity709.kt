package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_709")
data class Entity709(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity709Repository : org.springframework.data.jpa.repository.JpaRepository<Entity709, Long> {
    fun findByField1(field1: String): List<Entity709>
    fun findByField3GreaterThan(value: Int): List<Entity709>
}

@Service
@Transactional
class Service709(private val repo: Entity709Repository) {
    fun findAll(): List<Entity709> = repo.findAll()
    fun findByName(name: String): List<Entity709> = repo.findByField1(name)
    fun save(entity: Entity709): Entity709 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity709>): List<Entity709> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
