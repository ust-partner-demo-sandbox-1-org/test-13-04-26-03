package com.example.generated.module21

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_429")
data class Entity429(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity429Repository : org.springframework.data.jpa.repository.JpaRepository<Entity429, Long> {
    fun findByField1(field1: String): List<Entity429>
    fun findByField3GreaterThan(value: Int): List<Entity429>
}

@Service
@Transactional
class Service429(private val repo: Entity429Repository) {
    fun findAll(): List<Entity429> = repo.findAll()
    fun findByName(name: String): List<Entity429> = repo.findByField1(name)
    fun save(entity: Entity429): Entity429 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity429>): List<Entity429> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
