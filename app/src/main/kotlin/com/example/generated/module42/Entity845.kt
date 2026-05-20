package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_845")
data class Entity845(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity845Repository : org.springframework.data.jpa.repository.JpaRepository<Entity845, Long> {
    fun findByField1(field1: String): List<Entity845>
    fun findByField3GreaterThan(value: Int): List<Entity845>
}

@Service
@Transactional
class Service845(private val repo: Entity845Repository) {
    fun findAll(): List<Entity845> = repo.findAll()
    fun findByName(name: String): List<Entity845> = repo.findByField1(name)
    fun save(entity: Entity845): Entity845 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity845>): List<Entity845> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
