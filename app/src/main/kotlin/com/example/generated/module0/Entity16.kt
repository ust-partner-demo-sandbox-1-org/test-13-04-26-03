package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_16")
data class Entity16(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity16Repository : org.springframework.data.jpa.repository.JpaRepository<Entity16, Long> {
    fun findByField1(field1: String): List<Entity16>
    fun findByField3GreaterThan(value: Int): List<Entity16>
}

@Service
@Transactional
class Service16(private val repo: Entity16Repository) {
    fun findAll(): List<Entity16> = repo.findAll()
    fun findByName(name: String): List<Entity16> = repo.findByField1(name)
    fun save(entity: Entity16): Entity16 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity16>): List<Entity16> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
