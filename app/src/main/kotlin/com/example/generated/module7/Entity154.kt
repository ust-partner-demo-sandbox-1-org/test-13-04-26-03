package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_154")
data class Entity154(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity154Repository : org.springframework.data.jpa.repository.JpaRepository<Entity154, Long> {
    fun findByField1(field1: String): List<Entity154>
    fun findByField3GreaterThan(value: Int): List<Entity154>
}

@Service
@Transactional
class Service154(private val repo: Entity154Repository) {
    fun findAll(): List<Entity154> = repo.findAll()
    fun findByName(name: String): List<Entity154> = repo.findByField1(name)
    fun save(entity: Entity154): Entity154 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity154>): List<Entity154> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
