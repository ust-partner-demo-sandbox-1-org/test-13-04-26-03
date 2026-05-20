package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_174")
data class Entity174(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity174Repository : org.springframework.data.jpa.repository.JpaRepository<Entity174, Long> {
    fun findByField1(field1: String): List<Entity174>
    fun findByField3GreaterThan(value: Int): List<Entity174>
}

@Service
@Transactional
class Service174(private val repo: Entity174Repository) {
    fun findAll(): List<Entity174> = repo.findAll()
    fun findByName(name: String): List<Entity174> = repo.findByField1(name)
    fun save(entity: Entity174): Entity174 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity174>): List<Entity174> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
