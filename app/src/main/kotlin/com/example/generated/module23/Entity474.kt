package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_474")
data class Entity474(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity474Repository : org.springframework.data.jpa.repository.JpaRepository<Entity474, Long> {
    fun findByField1(field1: String): List<Entity474>
    fun findByField3GreaterThan(value: Int): List<Entity474>
}

@Service
@Transactional
class Service474(private val repo: Entity474Repository) {
    fun findAll(): List<Entity474> = repo.findAll()
    fun findByName(name: String): List<Entity474> = repo.findByField1(name)
    fun save(entity: Entity474): Entity474 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity474>): List<Entity474> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
