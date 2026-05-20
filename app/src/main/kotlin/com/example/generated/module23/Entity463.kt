package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_463")
data class Entity463(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity463Repository : org.springframework.data.jpa.repository.JpaRepository<Entity463, Long> {
    fun findByField1(field1: String): List<Entity463>
    fun findByField3GreaterThan(value: Int): List<Entity463>
}

@Service
@Transactional
class Service463(private val repo: Entity463Repository) {
    fun findAll(): List<Entity463> = repo.findAll()
    fun findByName(name: String): List<Entity463> = repo.findByField1(name)
    fun save(entity: Entity463): Entity463 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity463>): List<Entity463> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
