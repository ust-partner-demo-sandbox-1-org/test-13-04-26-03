package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_634")
data class Entity634(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity634Repository : org.springframework.data.jpa.repository.JpaRepository<Entity634, Long> {
    fun findByField1(field1: String): List<Entity634>
    fun findByField3GreaterThan(value: Int): List<Entity634>
}

@Service
@Transactional
class Service634(private val repo: Entity634Repository) {
    fun findAll(): List<Entity634> = repo.findAll()
    fun findByName(name: String): List<Entity634> = repo.findByField1(name)
    fun save(entity: Entity634): Entity634 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity634>): List<Entity634> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
