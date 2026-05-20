package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_42")
data class Entity42(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity42Repository : org.springframework.data.jpa.repository.JpaRepository<Entity42, Long> {
    fun findByField1(field1: String): List<Entity42>
    fun findByField3GreaterThan(value: Int): List<Entity42>
}

@Service
@Transactional
class Service42(private val repo: Entity42Repository) {
    fun findAll(): List<Entity42> = repo.findAll()
    fun findByName(name: String): List<Entity42> = repo.findByField1(name)
    fun save(entity: Entity42): Entity42 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity42>): List<Entity42> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
