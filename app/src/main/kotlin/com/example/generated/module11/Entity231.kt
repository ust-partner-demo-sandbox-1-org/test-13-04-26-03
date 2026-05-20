package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_231")
data class Entity231(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity231Repository : org.springframework.data.jpa.repository.JpaRepository<Entity231, Long> {
    fun findByField1(field1: String): List<Entity231>
    fun findByField3GreaterThan(value: Int): List<Entity231>
}

@Service
@Transactional
class Service231(private val repo: Entity231Repository) {
    fun findAll(): List<Entity231> = repo.findAll()
    fun findByName(name: String): List<Entity231> = repo.findByField1(name)
    fun save(entity: Entity231): Entity231 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity231>): List<Entity231> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
