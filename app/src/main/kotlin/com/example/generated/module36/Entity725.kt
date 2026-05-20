package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_725")
data class Entity725(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity725Repository : org.springframework.data.jpa.repository.JpaRepository<Entity725, Long> {
    fun findByField1(field1: String): List<Entity725>
    fun findByField3GreaterThan(value: Int): List<Entity725>
}

@Service
@Transactional
class Service725(private val repo: Entity725Repository) {
    fun findAll(): List<Entity725> = repo.findAll()
    fun findByName(name: String): List<Entity725> = repo.findByField1(name)
    fun save(entity: Entity725): Entity725 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity725>): List<Entity725> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
