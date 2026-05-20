package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_109")
data class Entity109(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity109Repository : org.springframework.data.jpa.repository.JpaRepository<Entity109, Long> {
    fun findByField1(field1: String): List<Entity109>
    fun findByField3GreaterThan(value: Int): List<Entity109>
}

@Service
@Transactional
class Service109(private val repo: Entity109Repository) {
    fun findAll(): List<Entity109> = repo.findAll()
    fun findByName(name: String): List<Entity109> = repo.findByField1(name)
    fun save(entity: Entity109): Entity109 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity109>): List<Entity109> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
