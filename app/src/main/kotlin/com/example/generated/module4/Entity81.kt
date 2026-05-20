package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_81")
data class Entity81(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity81Repository : org.springframework.data.jpa.repository.JpaRepository<Entity81, Long> {
    fun findByField1(field1: String): List<Entity81>
    fun findByField3GreaterThan(value: Int): List<Entity81>
}

@Service
@Transactional
class Service81(private val repo: Entity81Repository) {
    fun findAll(): List<Entity81> = repo.findAll()
    fun findByName(name: String): List<Entity81> = repo.findByField1(name)
    fun save(entity: Entity81): Entity81 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity81>): List<Entity81> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
