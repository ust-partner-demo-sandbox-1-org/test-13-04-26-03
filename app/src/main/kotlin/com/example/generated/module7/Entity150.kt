package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_150")
data class Entity150(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity150Repository : org.springframework.data.jpa.repository.JpaRepository<Entity150, Long> {
    fun findByField1(field1: String): List<Entity150>
    fun findByField3GreaterThan(value: Int): List<Entity150>
}

@Service
@Transactional
class Service150(private val repo: Entity150Repository) {
    fun findAll(): List<Entity150> = repo.findAll()
    fun findByName(name: String): List<Entity150> = repo.findByField1(name)
    fun save(entity: Entity150): Entity150 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity150>): List<Entity150> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
