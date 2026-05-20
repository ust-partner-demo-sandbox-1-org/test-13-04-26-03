package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_848")
data class Entity848(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity848Repository : org.springframework.data.jpa.repository.JpaRepository<Entity848, Long> {
    fun findByField1(field1: String): List<Entity848>
    fun findByField3GreaterThan(value: Int): List<Entity848>
}

@Service
@Transactional
class Service848(private val repo: Entity848Repository) {
    fun findAll(): List<Entity848> = repo.findAll()
    fun findByName(name: String): List<Entity848> = repo.findByField1(name)
    fun save(entity: Entity848): Entity848 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity848>): List<Entity848> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
