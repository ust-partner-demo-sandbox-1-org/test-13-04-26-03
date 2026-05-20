package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_1")
data class Entity1(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity1Repository : org.springframework.data.jpa.repository.JpaRepository<Entity1, Long> {
    fun findByField1(field1: String): List<Entity1>
    fun findByField3GreaterThan(value: Int): List<Entity1>
}

@Service
@Transactional
class Service1(private val repo: Entity1Repository) {
    fun findAll(): List<Entity1> = repo.findAll()
    fun findByName(name: String): List<Entity1> = repo.findByField1(name)
    fun save(entity: Entity1): Entity1 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity1>): List<Entity1> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
