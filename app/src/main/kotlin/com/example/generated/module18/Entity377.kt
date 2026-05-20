package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_377")
data class Entity377(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity377Repository : org.springframework.data.jpa.repository.JpaRepository<Entity377, Long> {
    fun findByField1(field1: String): List<Entity377>
    fun findByField3GreaterThan(value: Int): List<Entity377>
}

@Service
@Transactional
class Service377(private val repo: Entity377Repository) {
    fun findAll(): List<Entity377> = repo.findAll()
    fun findByName(name: String): List<Entity377> = repo.findByField1(name)
    fun save(entity: Entity377): Entity377 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity377>): List<Entity377> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
