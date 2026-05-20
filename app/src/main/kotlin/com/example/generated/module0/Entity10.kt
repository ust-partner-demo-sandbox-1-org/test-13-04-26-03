package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_10")
data class Entity10(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity10Repository : org.springframework.data.jpa.repository.JpaRepository<Entity10, Long> {
    fun findByField1(field1: String): List<Entity10>
    fun findByField3GreaterThan(value: Int): List<Entity10>
}

@Service
@Transactional
class Service10(private val repo: Entity10Repository) {
    fun findAll(): List<Entity10> = repo.findAll()
    fun findByName(name: String): List<Entity10> = repo.findByField1(name)
    fun save(entity: Entity10): Entity10 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity10>): List<Entity10> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
