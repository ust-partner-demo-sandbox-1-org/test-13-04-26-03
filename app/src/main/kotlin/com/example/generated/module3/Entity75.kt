package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_75")
data class Entity75(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity75Repository : org.springframework.data.jpa.repository.JpaRepository<Entity75, Long> {
    fun findByField1(field1: String): List<Entity75>
    fun findByField3GreaterThan(value: Int): List<Entity75>
}

@Service
@Transactional
class Service75(private val repo: Entity75Repository) {
    fun findAll(): List<Entity75> = repo.findAll()
    fun findByName(name: String): List<Entity75> = repo.findByField1(name)
    fun save(entity: Entity75): Entity75 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity75>): List<Entity75> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
