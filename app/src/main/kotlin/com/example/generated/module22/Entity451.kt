package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_451")
data class Entity451(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity451Repository : org.springframework.data.jpa.repository.JpaRepository<Entity451, Long> {
    fun findByField1(field1: String): List<Entity451>
    fun findByField3GreaterThan(value: Int): List<Entity451>
}

@Service
@Transactional
class Service451(private val repo: Entity451Repository) {
    fun findAll(): List<Entity451> = repo.findAll()
    fun findByName(name: String): List<Entity451> = repo.findByField1(name)
    fun save(entity: Entity451): Entity451 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity451>): List<Entity451> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
