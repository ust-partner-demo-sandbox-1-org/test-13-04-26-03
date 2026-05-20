package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_270")
data class Entity270(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity270Repository : org.springframework.data.jpa.repository.JpaRepository<Entity270, Long> {
    fun findByField1(field1: String): List<Entity270>
    fun findByField3GreaterThan(value: Int): List<Entity270>
}

@Service
@Transactional
class Service270(private val repo: Entity270Repository) {
    fun findAll(): List<Entity270> = repo.findAll()
    fun findByName(name: String): List<Entity270> = repo.findByField1(name)
    fun save(entity: Entity270): Entity270 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity270>): List<Entity270> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
