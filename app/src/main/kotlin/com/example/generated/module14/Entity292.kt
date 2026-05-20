package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_292")
data class Entity292(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity292Repository : org.springframework.data.jpa.repository.JpaRepository<Entity292, Long> {
    fun findByField1(field1: String): List<Entity292>
    fun findByField3GreaterThan(value: Int): List<Entity292>
}

@Service
@Transactional
class Service292(private val repo: Entity292Repository) {
    fun findAll(): List<Entity292> = repo.findAll()
    fun findByName(name: String): List<Entity292> = repo.findByField1(name)
    fun save(entity: Entity292): Entity292 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity292>): List<Entity292> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
