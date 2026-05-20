package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_814")
data class Entity814(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity814Repository : org.springframework.data.jpa.repository.JpaRepository<Entity814, Long> {
    fun findByField1(field1: String): List<Entity814>
    fun findByField3GreaterThan(value: Int): List<Entity814>
}

@Service
@Transactional
class Service814(private val repo: Entity814Repository) {
    fun findAll(): List<Entity814> = repo.findAll()
    fun findByName(name: String): List<Entity814> = repo.findByField1(name)
    fun save(entity: Entity814): Entity814 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity814>): List<Entity814> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
