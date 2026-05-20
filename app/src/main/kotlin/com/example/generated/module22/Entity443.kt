package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_443")
data class Entity443(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity443Repository : org.springframework.data.jpa.repository.JpaRepository<Entity443, Long> {
    fun findByField1(field1: String): List<Entity443>
    fun findByField3GreaterThan(value: Int): List<Entity443>
}

@Service
@Transactional
class Service443(private val repo: Entity443Repository) {
    fun findAll(): List<Entity443> = repo.findAll()
    fun findByName(name: String): List<Entity443> = repo.findByField1(name)
    fun save(entity: Entity443): Entity443 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity443>): List<Entity443> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
