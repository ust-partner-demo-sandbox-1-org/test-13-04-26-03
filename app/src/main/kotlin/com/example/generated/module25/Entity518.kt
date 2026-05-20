package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_518")
data class Entity518(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity518Repository : org.springframework.data.jpa.repository.JpaRepository<Entity518, Long> {
    fun findByField1(field1: String): List<Entity518>
    fun findByField3GreaterThan(value: Int): List<Entity518>
}

@Service
@Transactional
class Service518(private val repo: Entity518Repository) {
    fun findAll(): List<Entity518> = repo.findAll()
    fun findByName(name: String): List<Entity518> = repo.findByField1(name)
    fun save(entity: Entity518): Entity518 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity518>): List<Entity518> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
