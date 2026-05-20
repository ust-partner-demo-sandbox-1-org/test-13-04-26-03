package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_267")
data class Entity267(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity267Repository : org.springframework.data.jpa.repository.JpaRepository<Entity267, Long> {
    fun findByField1(field1: String): List<Entity267>
    fun findByField3GreaterThan(value: Int): List<Entity267>
}

@Service
@Transactional
class Service267(private val repo: Entity267Repository) {
    fun findAll(): List<Entity267> = repo.findAll()
    fun findByName(name: String): List<Entity267> = repo.findByField1(name)
    fun save(entity: Entity267): Entity267 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity267>): List<Entity267> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
