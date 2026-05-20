package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_282")
data class Entity282(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity282Repository : org.springframework.data.jpa.repository.JpaRepository<Entity282, Long> {
    fun findByField1(field1: String): List<Entity282>
    fun findByField3GreaterThan(value: Int): List<Entity282>
}

@Service
@Transactional
class Service282(private val repo: Entity282Repository) {
    fun findAll(): List<Entity282> = repo.findAll()
    fun findByName(name: String): List<Entity282> = repo.findByField1(name)
    fun save(entity: Entity282): Entity282 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity282>): List<Entity282> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
