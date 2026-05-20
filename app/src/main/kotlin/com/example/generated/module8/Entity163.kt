package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_163")
data class Entity163(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity163Repository : org.springframework.data.jpa.repository.JpaRepository<Entity163, Long> {
    fun findByField1(field1: String): List<Entity163>
    fun findByField3GreaterThan(value: Int): List<Entity163>
}

@Service
@Transactional
class Service163(private val repo: Entity163Repository) {
    fun findAll(): List<Entity163> = repo.findAll()
    fun findByName(name: String): List<Entity163> = repo.findByField1(name)
    fun save(entity: Entity163): Entity163 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity163>): List<Entity163> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
