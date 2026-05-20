package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_3")
data class Entity3(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity3Repository : org.springframework.data.jpa.repository.JpaRepository<Entity3, Long> {
    fun findByField1(field1: String): List<Entity3>
    fun findByField3GreaterThan(value: Int): List<Entity3>
}

@Service
@Transactional
class Service3(private val repo: Entity3Repository) {
    fun findAll(): List<Entity3> = repo.findAll()
    fun findByName(name: String): List<Entity3> = repo.findByField1(name)
    fun save(entity: Entity3): Entity3 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity3>): List<Entity3> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
