package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_515")
data class Entity515(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity515Repository : org.springframework.data.jpa.repository.JpaRepository<Entity515, Long> {
    fun findByField1(field1: String): List<Entity515>
    fun findByField3GreaterThan(value: Int): List<Entity515>
}

@Service
@Transactional
class Service515(private val repo: Entity515Repository) {
    fun findAll(): List<Entity515> = repo.findAll()
    fun findByName(name: String): List<Entity515> = repo.findByField1(name)
    fun save(entity: Entity515): Entity515 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity515>): List<Entity515> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
