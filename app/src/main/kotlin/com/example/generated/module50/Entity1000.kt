package com.example.generated.module50

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_1000")
data class Entity1000(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity1000Repository : org.springframework.data.jpa.repository.JpaRepository<Entity1000, Long> {
    fun findByField1(field1: String): List<Entity1000>
    fun findByField3GreaterThan(value: Int): List<Entity1000>
}

@Service
@Transactional
class Service1000(private val repo: Entity1000Repository) {
    fun findAll(): List<Entity1000> = repo.findAll()
    fun findByName(name: String): List<Entity1000> = repo.findByField1(name)
    fun save(entity: Entity1000): Entity1000 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity1000>): List<Entity1000> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
