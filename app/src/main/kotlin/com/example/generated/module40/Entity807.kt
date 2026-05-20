package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_807")
data class Entity807(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity807Repository : org.springframework.data.jpa.repository.JpaRepository<Entity807, Long> {
    fun findByField1(field1: String): List<Entity807>
    fun findByField3GreaterThan(value: Int): List<Entity807>
}

@Service
@Transactional
class Service807(private val repo: Entity807Repository) {
    fun findAll(): List<Entity807> = repo.findAll()
    fun findByName(name: String): List<Entity807> = repo.findByField1(name)
    fun save(entity: Entity807): Entity807 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity807>): List<Entity807> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
