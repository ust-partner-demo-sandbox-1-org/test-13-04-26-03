package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_284")
data class Entity284(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity284Repository : org.springframework.data.jpa.repository.JpaRepository<Entity284, Long> {
    fun findByField1(field1: String): List<Entity284>
    fun findByField3GreaterThan(value: Int): List<Entity284>
}

@Service
@Transactional
class Service284(private val repo: Entity284Repository) {
    fun findAll(): List<Entity284> = repo.findAll()
    fun findByName(name: String): List<Entity284> = repo.findByField1(name)
    fun save(entity: Entity284): Entity284 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity284>): List<Entity284> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
