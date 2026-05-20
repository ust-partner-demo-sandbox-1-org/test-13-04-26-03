package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_74")
data class Entity74(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity74Repository : org.springframework.data.jpa.repository.JpaRepository<Entity74, Long> {
    fun findByField1(field1: String): List<Entity74>
    fun findByField3GreaterThan(value: Int): List<Entity74>
}

@Service
@Transactional
class Service74(private val repo: Entity74Repository) {
    fun findAll(): List<Entity74> = repo.findAll()
    fun findByName(name: String): List<Entity74> = repo.findByField1(name)
    fun save(entity: Entity74): Entity74 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity74>): List<Entity74> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
