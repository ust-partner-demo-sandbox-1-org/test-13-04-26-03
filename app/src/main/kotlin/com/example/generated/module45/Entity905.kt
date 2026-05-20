package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_905")
data class Entity905(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity905Repository : org.springframework.data.jpa.repository.JpaRepository<Entity905, Long> {
    fun findByField1(field1: String): List<Entity905>
    fun findByField3GreaterThan(value: Int): List<Entity905>
}

@Service
@Transactional
class Service905(private val repo: Entity905Repository) {
    fun findAll(): List<Entity905> = repo.findAll()
    fun findByName(name: String): List<Entity905> = repo.findByField1(name)
    fun save(entity: Entity905): Entity905 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity905>): List<Entity905> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
