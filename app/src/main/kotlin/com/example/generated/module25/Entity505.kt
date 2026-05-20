package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_505")
data class Entity505(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity505Repository : org.springframework.data.jpa.repository.JpaRepository<Entity505, Long> {
    fun findByField1(field1: String): List<Entity505>
    fun findByField3GreaterThan(value: Int): List<Entity505>
}

@Service
@Transactional
class Service505(private val repo: Entity505Repository) {
    fun findAll(): List<Entity505> = repo.findAll()
    fun findByName(name: String): List<Entity505> = repo.findByField1(name)
    fun save(entity: Entity505): Entity505 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity505>): List<Entity505> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
