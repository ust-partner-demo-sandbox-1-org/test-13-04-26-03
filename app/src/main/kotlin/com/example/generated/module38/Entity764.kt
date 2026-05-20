package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_764")
data class Entity764(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity764Repository : org.springframework.data.jpa.repository.JpaRepository<Entity764, Long> {
    fun findByField1(field1: String): List<Entity764>
    fun findByField3GreaterThan(value: Int): List<Entity764>
}

@Service
@Transactional
class Service764(private val repo: Entity764Repository) {
    fun findAll(): List<Entity764> = repo.findAll()
    fun findByName(name: String): List<Entity764> = repo.findByField1(name)
    fun save(entity: Entity764): Entity764 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity764>): List<Entity764> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
