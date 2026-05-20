package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_503")
data class Entity503(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity503Repository : org.springframework.data.jpa.repository.JpaRepository<Entity503, Long> {
    fun findByField1(field1: String): List<Entity503>
    fun findByField3GreaterThan(value: Int): List<Entity503>
}

@Service
@Transactional
class Service503(private val repo: Entity503Repository) {
    fun findAll(): List<Entity503> = repo.findAll()
    fun findByName(name: String): List<Entity503> = repo.findByField1(name)
    fun save(entity: Entity503): Entity503 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity503>): List<Entity503> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
