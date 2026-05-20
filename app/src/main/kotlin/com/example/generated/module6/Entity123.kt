package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_123")
data class Entity123(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity123Repository : org.springframework.data.jpa.repository.JpaRepository<Entity123, Long> {
    fun findByField1(field1: String): List<Entity123>
    fun findByField3GreaterThan(value: Int): List<Entity123>
}

@Service
@Transactional
class Service123(private val repo: Entity123Repository) {
    fun findAll(): List<Entity123> = repo.findAll()
    fun findByName(name: String): List<Entity123> = repo.findByField1(name)
    fun save(entity: Entity123): Entity123 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity123>): List<Entity123> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
