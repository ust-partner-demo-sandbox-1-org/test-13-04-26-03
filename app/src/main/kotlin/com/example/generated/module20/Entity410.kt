package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_410")
data class Entity410(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity410Repository : org.springframework.data.jpa.repository.JpaRepository<Entity410, Long> {
    fun findByField1(field1: String): List<Entity410>
    fun findByField3GreaterThan(value: Int): List<Entity410>
}

@Service
@Transactional
class Service410(private val repo: Entity410Repository) {
    fun findAll(): List<Entity410> = repo.findAll()
    fun findByName(name: String): List<Entity410> = repo.findByField1(name)
    fun save(entity: Entity410): Entity410 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity410>): List<Entity410> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
