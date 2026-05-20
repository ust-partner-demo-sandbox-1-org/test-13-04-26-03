package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_919")
data class Entity919(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity919Repository : org.springframework.data.jpa.repository.JpaRepository<Entity919, Long> {
    fun findByField1(field1: String): List<Entity919>
    fun findByField3GreaterThan(value: Int): List<Entity919>
}

@Service
@Transactional
class Service919(private val repo: Entity919Repository) {
    fun findAll(): List<Entity919> = repo.findAll()
    fun findByName(name: String): List<Entity919> = repo.findByField1(name)
    fun save(entity: Entity919): Entity919 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity919>): List<Entity919> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
