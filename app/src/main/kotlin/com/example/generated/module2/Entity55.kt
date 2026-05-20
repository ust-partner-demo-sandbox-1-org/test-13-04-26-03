package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_55")
data class Entity55(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity55Repository : org.springframework.data.jpa.repository.JpaRepository<Entity55, Long> {
    fun findByField1(field1: String): List<Entity55>
    fun findByField3GreaterThan(value: Int): List<Entity55>
}

@Service
@Transactional
class Service55(private val repo: Entity55Repository) {
    fun findAll(): List<Entity55> = repo.findAll()
    fun findByName(name: String): List<Entity55> = repo.findByField1(name)
    fun save(entity: Entity55): Entity55 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity55>): List<Entity55> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
