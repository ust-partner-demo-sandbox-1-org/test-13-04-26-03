package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_171")
data class Entity171(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity171Repository : org.springframework.data.jpa.repository.JpaRepository<Entity171, Long> {
    fun findByField1(field1: String): List<Entity171>
    fun findByField3GreaterThan(value: Int): List<Entity171>
}

@Service
@Transactional
class Service171(private val repo: Entity171Repository) {
    fun findAll(): List<Entity171> = repo.findAll()
    fun findByName(name: String): List<Entity171> = repo.findByField1(name)
    fun save(entity: Entity171): Entity171 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity171>): List<Entity171> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
