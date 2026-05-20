package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_557")
data class Entity557(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity557Repository : org.springframework.data.jpa.repository.JpaRepository<Entity557, Long> {
    fun findByField1(field1: String): List<Entity557>
    fun findByField3GreaterThan(value: Int): List<Entity557>
}

@Service
@Transactional
class Service557(private val repo: Entity557Repository) {
    fun findAll(): List<Entity557> = repo.findAll()
    fun findByName(name: String): List<Entity557> = repo.findByField1(name)
    fun save(entity: Entity557): Entity557 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity557>): List<Entity557> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
