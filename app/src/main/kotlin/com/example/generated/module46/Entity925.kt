package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_925")
data class Entity925(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity925Repository : org.springframework.data.jpa.repository.JpaRepository<Entity925, Long> {
    fun findByField1(field1: String): List<Entity925>
    fun findByField3GreaterThan(value: Int): List<Entity925>
}

@Service
@Transactional
class Service925(private val repo: Entity925Repository) {
    fun findAll(): List<Entity925> = repo.findAll()
    fun findByName(name: String): List<Entity925> = repo.findByField1(name)
    fun save(entity: Entity925): Entity925 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity925>): List<Entity925> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
