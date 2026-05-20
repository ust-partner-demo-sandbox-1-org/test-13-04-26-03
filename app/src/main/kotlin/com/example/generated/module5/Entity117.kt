package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_117")
data class Entity117(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity117Repository : org.springframework.data.jpa.repository.JpaRepository<Entity117, Long> {
    fun findByField1(field1: String): List<Entity117>
    fun findByField3GreaterThan(value: Int): List<Entity117>
}

@Service
@Transactional
class Service117(private val repo: Entity117Repository) {
    fun findAll(): List<Entity117> = repo.findAll()
    fun findByName(name: String): List<Entity117> = repo.findByField1(name)
    fun save(entity: Entity117): Entity117 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity117>): List<Entity117> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
