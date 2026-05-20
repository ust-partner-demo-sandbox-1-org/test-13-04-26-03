package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_67")
data class Entity67(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity67Repository : org.springframework.data.jpa.repository.JpaRepository<Entity67, Long> {
    fun findByField1(field1: String): List<Entity67>
    fun findByField3GreaterThan(value: Int): List<Entity67>
}

@Service
@Transactional
class Service67(private val repo: Entity67Repository) {
    fun findAll(): List<Entity67> = repo.findAll()
    fun findByName(name: String): List<Entity67> = repo.findByField1(name)
    fun save(entity: Entity67): Entity67 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity67>): List<Entity67> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
