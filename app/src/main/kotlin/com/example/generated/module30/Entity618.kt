package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_618")
data class Entity618(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity618Repository : org.springframework.data.jpa.repository.JpaRepository<Entity618, Long> {
    fun findByField1(field1: String): List<Entity618>
    fun findByField3GreaterThan(value: Int): List<Entity618>
}

@Service
@Transactional
class Service618(private val repo: Entity618Repository) {
    fun findAll(): List<Entity618> = repo.findAll()
    fun findByName(name: String): List<Entity618> = repo.findByField1(name)
    fun save(entity: Entity618): Entity618 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity618>): List<Entity618> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
