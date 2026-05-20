package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_251")
data class Entity251(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity251Repository : org.springframework.data.jpa.repository.JpaRepository<Entity251, Long> {
    fun findByField1(field1: String): List<Entity251>
    fun findByField3GreaterThan(value: Int): List<Entity251>
}

@Service
@Transactional
class Service251(private val repo: Entity251Repository) {
    fun findAll(): List<Entity251> = repo.findAll()
    fun findByName(name: String): List<Entity251> = repo.findByField1(name)
    fun save(entity: Entity251): Entity251 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity251>): List<Entity251> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
