package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_366")
data class Entity366(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity366Repository : org.springframework.data.jpa.repository.JpaRepository<Entity366, Long> {
    fun findByField1(field1: String): List<Entity366>
    fun findByField3GreaterThan(value: Int): List<Entity366>
}

@Service
@Transactional
class Service366(private val repo: Entity366Repository) {
    fun findAll(): List<Entity366> = repo.findAll()
    fun findByName(name: String): List<Entity366> = repo.findByField1(name)
    fun save(entity: Entity366): Entity366 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity366>): List<Entity366> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
