package com.example.generated.module21

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_436")
data class Entity436(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity436Repository : org.springframework.data.jpa.repository.JpaRepository<Entity436, Long> {
    fun findByField1(field1: String): List<Entity436>
    fun findByField3GreaterThan(value: Int): List<Entity436>
}

@Service
@Transactional
class Service436(private val repo: Entity436Repository) {
    fun findAll(): List<Entity436> = repo.findAll()
    fun findByName(name: String): List<Entity436> = repo.findByField1(name)
    fun save(entity: Entity436): Entity436 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity436>): List<Entity436> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
