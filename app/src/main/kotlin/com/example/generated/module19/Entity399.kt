package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_399")
data class Entity399(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity399Repository : org.springframework.data.jpa.repository.JpaRepository<Entity399, Long> {
    fun findByField1(field1: String): List<Entity399>
    fun findByField3GreaterThan(value: Int): List<Entity399>
}

@Service
@Transactional
class Service399(private val repo: Entity399Repository) {
    fun findAll(): List<Entity399> = repo.findAll()
    fun findByName(name: String): List<Entity399> = repo.findByField1(name)
    fun save(entity: Entity399): Entity399 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity399>): List<Entity399> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
