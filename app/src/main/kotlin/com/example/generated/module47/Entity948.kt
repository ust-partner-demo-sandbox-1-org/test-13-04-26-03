package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_948")
data class Entity948(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity948Repository : org.springframework.data.jpa.repository.JpaRepository<Entity948, Long> {
    fun findByField1(field1: String): List<Entity948>
    fun findByField3GreaterThan(value: Int): List<Entity948>
}

@Service
@Transactional
class Service948(private val repo: Entity948Repository) {
    fun findAll(): List<Entity948> = repo.findAll()
    fun findByName(name: String): List<Entity948> = repo.findByField1(name)
    fun save(entity: Entity948): Entity948 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity948>): List<Entity948> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
