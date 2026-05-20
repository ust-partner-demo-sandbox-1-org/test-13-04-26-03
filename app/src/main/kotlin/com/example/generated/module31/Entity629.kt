package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_629")
data class Entity629(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity629Repository : org.springframework.data.jpa.repository.JpaRepository<Entity629, Long> {
    fun findByField1(field1: String): List<Entity629>
    fun findByField3GreaterThan(value: Int): List<Entity629>
}

@Service
@Transactional
class Service629(private val repo: Entity629Repository) {
    fun findAll(): List<Entity629> = repo.findAll()
    fun findByName(name: String): List<Entity629> = repo.findByField1(name)
    fun save(entity: Entity629): Entity629 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity629>): List<Entity629> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
