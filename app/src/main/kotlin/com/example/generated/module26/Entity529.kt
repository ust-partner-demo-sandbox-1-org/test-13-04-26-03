package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_529")
data class Entity529(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity529Repository : org.springframework.data.jpa.repository.JpaRepository<Entity529, Long> {
    fun findByField1(field1: String): List<Entity529>
    fun findByField3GreaterThan(value: Int): List<Entity529>
}

@Service
@Transactional
class Service529(private val repo: Entity529Repository) {
    fun findAll(): List<Entity529> = repo.findAll()
    fun findByName(name: String): List<Entity529> = repo.findByField1(name)
    fun save(entity: Entity529): Entity529 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity529>): List<Entity529> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
