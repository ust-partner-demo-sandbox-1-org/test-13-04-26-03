package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_216")
data class Entity216(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity216Repository : org.springframework.data.jpa.repository.JpaRepository<Entity216, Long> {
    fun findByField1(field1: String): List<Entity216>
    fun findByField3GreaterThan(value: Int): List<Entity216>
}

@Service
@Transactional
class Service216(private val repo: Entity216Repository) {
    fun findAll(): List<Entity216> = repo.findAll()
    fun findByName(name: String): List<Entity216> = repo.findByField1(name)
    fun save(entity: Entity216): Entity216 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity216>): List<Entity216> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
