package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_834")
data class Entity834(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity834Repository : org.springframework.data.jpa.repository.JpaRepository<Entity834, Long> {
    fun findByField1(field1: String): List<Entity834>
    fun findByField3GreaterThan(value: Int): List<Entity834>
}

@Service
@Transactional
class Service834(private val repo: Entity834Repository) {
    fun findAll(): List<Entity834> = repo.findAll()
    fun findByName(name: String): List<Entity834> = repo.findByField1(name)
    fun save(entity: Entity834): Entity834 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity834>): List<Entity834> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
