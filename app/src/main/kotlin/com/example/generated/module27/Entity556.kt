package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_556")
data class Entity556(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity556Repository : org.springframework.data.jpa.repository.JpaRepository<Entity556, Long> {
    fun findByField1(field1: String): List<Entity556>
    fun findByField3GreaterThan(value: Int): List<Entity556>
}

@Service
@Transactional
class Service556(private val repo: Entity556Repository) {
    fun findAll(): List<Entity556> = repo.findAll()
    fun findByName(name: String): List<Entity556> = repo.findByField1(name)
    fun save(entity: Entity556): Entity556 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity556>): List<Entity556> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
