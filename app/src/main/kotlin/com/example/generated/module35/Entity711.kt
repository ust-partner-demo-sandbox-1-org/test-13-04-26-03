package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_711")
data class Entity711(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity711Repository : org.springframework.data.jpa.repository.JpaRepository<Entity711, Long> {
    fun findByField1(field1: String): List<Entity711>
    fun findByField3GreaterThan(value: Int): List<Entity711>
}

@Service
@Transactional
class Service711(private val repo: Entity711Repository) {
    fun findAll(): List<Entity711> = repo.findAll()
    fun findByName(name: String): List<Entity711> = repo.findByField1(name)
    fun save(entity: Entity711): Entity711 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity711>): List<Entity711> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
