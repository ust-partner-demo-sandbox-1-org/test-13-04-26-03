package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_203")
data class Entity203(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity203Repository : org.springframework.data.jpa.repository.JpaRepository<Entity203, Long> {
    fun findByField1(field1: String): List<Entity203>
    fun findByField3GreaterThan(value: Int): List<Entity203>
}

@Service
@Transactional
class Service203(private val repo: Entity203Repository) {
    fun findAll(): List<Entity203> = repo.findAll()
    fun findByName(name: String): List<Entity203> = repo.findByField1(name)
    fun save(entity: Entity203): Entity203 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity203>): List<Entity203> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
