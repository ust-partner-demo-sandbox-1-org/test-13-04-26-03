package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_677")
data class Entity677(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity677Repository : org.springframework.data.jpa.repository.JpaRepository<Entity677, Long> {
    fun findByField1(field1: String): List<Entity677>
    fun findByField3GreaterThan(value: Int): List<Entity677>
}

@Service
@Transactional
class Service677(private val repo: Entity677Repository) {
    fun findAll(): List<Entity677> = repo.findAll()
    fun findByName(name: String): List<Entity677> = repo.findByField1(name)
    fun save(entity: Entity677): Entity677 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity677>): List<Entity677> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
