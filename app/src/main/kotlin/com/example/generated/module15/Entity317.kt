package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_317")
data class Entity317(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity317Repository : org.springframework.data.jpa.repository.JpaRepository<Entity317, Long> {
    fun findByField1(field1: String): List<Entity317>
    fun findByField3GreaterThan(value: Int): List<Entity317>
}

@Service
@Transactional
class Service317(private val repo: Entity317Repository) {
    fun findAll(): List<Entity317> = repo.findAll()
    fun findByName(name: String): List<Entity317> = repo.findByField1(name)
    fun save(entity: Entity317): Entity317 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity317>): List<Entity317> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
