package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_368")
data class Entity368(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity368Repository : org.springframework.data.jpa.repository.JpaRepository<Entity368, Long> {
    fun findByField1(field1: String): List<Entity368>
    fun findByField3GreaterThan(value: Int): List<Entity368>
}

@Service
@Transactional
class Service368(private val repo: Entity368Repository) {
    fun findAll(): List<Entity368> = repo.findAll()
    fun findByName(name: String): List<Entity368> = repo.findByField1(name)
    fun save(entity: Entity368): Entity368 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity368>): List<Entity368> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
