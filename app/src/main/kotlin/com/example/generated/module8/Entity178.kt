package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_178")
data class Entity178(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity178Repository : org.springframework.data.jpa.repository.JpaRepository<Entity178, Long> {
    fun findByField1(field1: String): List<Entity178>
    fun findByField3GreaterThan(value: Int): List<Entity178>
}

@Service
@Transactional
class Service178(private val repo: Entity178Repository) {
    fun findAll(): List<Entity178> = repo.findAll()
    fun findByName(name: String): List<Entity178> = repo.findByField1(name)
    fun save(entity: Entity178): Entity178 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity178>): List<Entity178> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
