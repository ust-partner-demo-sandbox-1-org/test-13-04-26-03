package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_206")
data class Entity206(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity206Repository : org.springframework.data.jpa.repository.JpaRepository<Entity206, Long> {
    fun findByField1(field1: String): List<Entity206>
    fun findByField3GreaterThan(value: Int): List<Entity206>
}

@Service
@Transactional
class Service206(private val repo: Entity206Repository) {
    fun findAll(): List<Entity206> = repo.findAll()
    fun findByName(name: String): List<Entity206> = repo.findByField1(name)
    fun save(entity: Entity206): Entity206 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity206>): List<Entity206> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
