package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_736")
data class Entity736(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity736Repository : org.springframework.data.jpa.repository.JpaRepository<Entity736, Long> {
    fun findByField1(field1: String): List<Entity736>
    fun findByField3GreaterThan(value: Int): List<Entity736>
}

@Service
@Transactional
class Service736(private val repo: Entity736Repository) {
    fun findAll(): List<Entity736> = repo.findAll()
    fun findByName(name: String): List<Entity736> = repo.findByField1(name)
    fun save(entity: Entity736): Entity736 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity736>): List<Entity736> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
