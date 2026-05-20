package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_985")
data class Entity985(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity985Repository : org.springframework.data.jpa.repository.JpaRepository<Entity985, Long> {
    fun findByField1(field1: String): List<Entity985>
    fun findByField3GreaterThan(value: Int): List<Entity985>
}

@Service
@Transactional
class Service985(private val repo: Entity985Repository) {
    fun findAll(): List<Entity985> = repo.findAll()
    fun findByName(name: String): List<Entity985> = repo.findByField1(name)
    fun save(entity: Entity985): Entity985 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity985>): List<Entity985> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
