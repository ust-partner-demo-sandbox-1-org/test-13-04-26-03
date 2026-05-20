package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_501")
data class Entity501(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity501Repository : org.springframework.data.jpa.repository.JpaRepository<Entity501, Long> {
    fun findByField1(field1: String): List<Entity501>
    fun findByField3GreaterThan(value: Int): List<Entity501>
}

@Service
@Transactional
class Service501(private val repo: Entity501Repository) {
    fun findAll(): List<Entity501> = repo.findAll()
    fun findByName(name: String): List<Entity501> = repo.findByField1(name)
    fun save(entity: Entity501): Entity501 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity501>): List<Entity501> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
