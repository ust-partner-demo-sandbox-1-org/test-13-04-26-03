package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_455")
data class Entity455(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity455Repository : org.springframework.data.jpa.repository.JpaRepository<Entity455, Long> {
    fun findByField1(field1: String): List<Entity455>
    fun findByField3GreaterThan(value: Int): List<Entity455>
}

@Service
@Transactional
class Service455(private val repo: Entity455Repository) {
    fun findAll(): List<Entity455> = repo.findAll()
    fun findByName(name: String): List<Entity455> = repo.findByField1(name)
    fun save(entity: Entity455): Entity455 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity455>): List<Entity455> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
