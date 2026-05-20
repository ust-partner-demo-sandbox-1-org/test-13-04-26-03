package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_398")
data class Entity398(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity398Repository : org.springframework.data.jpa.repository.JpaRepository<Entity398, Long> {
    fun findByField1(field1: String): List<Entity398>
    fun findByField3GreaterThan(value: Int): List<Entity398>
}

@Service
@Transactional
class Service398(private val repo: Entity398Repository) {
    fun findAll(): List<Entity398> = repo.findAll()
    fun findByName(name: String): List<Entity398> = repo.findByField1(name)
    fun save(entity: Entity398): Entity398 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity398>): List<Entity398> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
