package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_275")
data class Entity275(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity275Repository : org.springframework.data.jpa.repository.JpaRepository<Entity275, Long> {
    fun findByField1(field1: String): List<Entity275>
    fun findByField3GreaterThan(value: Int): List<Entity275>
}

@Service
@Transactional
class Service275(private val repo: Entity275Repository) {
    fun findAll(): List<Entity275> = repo.findAll()
    fun findByName(name: String): List<Entity275> = repo.findByField1(name)
    fun save(entity: Entity275): Entity275 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity275>): List<Entity275> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
