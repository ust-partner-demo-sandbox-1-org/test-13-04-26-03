package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_387")
data class Entity387(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity387Repository : org.springframework.data.jpa.repository.JpaRepository<Entity387, Long> {
    fun findByField1(field1: String): List<Entity387>
    fun findByField3GreaterThan(value: Int): List<Entity387>
}

@Service
@Transactional
class Service387(private val repo: Entity387Repository) {
    fun findAll(): List<Entity387> = repo.findAll()
    fun findByName(name: String): List<Entity387> = repo.findByField1(name)
    fun save(entity: Entity387): Entity387 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity387>): List<Entity387> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
