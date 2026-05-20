package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_349")
data class Entity349(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity349Repository : org.springframework.data.jpa.repository.JpaRepository<Entity349, Long> {
    fun findByField1(field1: String): List<Entity349>
    fun findByField3GreaterThan(value: Int): List<Entity349>
}

@Service
@Transactional
class Service349(private val repo: Entity349Repository) {
    fun findAll(): List<Entity349> = repo.findAll()
    fun findByName(name: String): List<Entity349> = repo.findByField1(name)
    fun save(entity: Entity349): Entity349 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity349>): List<Entity349> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
