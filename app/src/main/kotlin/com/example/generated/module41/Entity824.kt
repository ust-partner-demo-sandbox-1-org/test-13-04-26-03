package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_824")
data class Entity824(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity824Repository : org.springframework.data.jpa.repository.JpaRepository<Entity824, Long> {
    fun findByField1(field1: String): List<Entity824>
    fun findByField3GreaterThan(value: Int): List<Entity824>
}

@Service
@Transactional
class Service824(private val repo: Entity824Repository) {
    fun findAll(): List<Entity824> = repo.findAll()
    fun findByName(name: String): List<Entity824> = repo.findByField1(name)
    fun save(entity: Entity824): Entity824 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity824>): List<Entity824> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
