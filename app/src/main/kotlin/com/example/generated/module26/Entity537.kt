package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_537")
data class Entity537(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity537Repository : org.springframework.data.jpa.repository.JpaRepository<Entity537, Long> {
    fun findByField1(field1: String): List<Entity537>
    fun findByField3GreaterThan(value: Int): List<Entity537>
}

@Service
@Transactional
class Service537(private val repo: Entity537Repository) {
    fun findAll(): List<Entity537> = repo.findAll()
    fun findByName(name: String): List<Entity537> = repo.findByField1(name)
    fun save(entity: Entity537): Entity537 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity537>): List<Entity537> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
