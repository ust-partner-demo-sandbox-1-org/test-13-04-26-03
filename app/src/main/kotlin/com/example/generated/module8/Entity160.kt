package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_160")
data class Entity160(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity160Repository : org.springframework.data.jpa.repository.JpaRepository<Entity160, Long> {
    fun findByField1(field1: String): List<Entity160>
    fun findByField3GreaterThan(value: Int): List<Entity160>
}

@Service
@Transactional
class Service160(private val repo: Entity160Repository) {
    fun findAll(): List<Entity160> = repo.findAll()
    fun findByName(name: String): List<Entity160> = repo.findByField1(name)
    fun save(entity: Entity160): Entity160 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity160>): List<Entity160> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
