package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_499")
data class Entity499(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity499Repository : org.springframework.data.jpa.repository.JpaRepository<Entity499, Long> {
    fun findByField1(field1: String): List<Entity499>
    fun findByField3GreaterThan(value: Int): List<Entity499>
}

@Service
@Transactional
class Service499(private val repo: Entity499Repository) {
    fun findAll(): List<Entity499> = repo.findAll()
    fun findByName(name: String): List<Entity499> = repo.findByField1(name)
    fun save(entity: Entity499): Entity499 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity499>): List<Entity499> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
