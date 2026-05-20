package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_792")
data class Entity792(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity792Repository : org.springframework.data.jpa.repository.JpaRepository<Entity792, Long> {
    fun findByField1(field1: String): List<Entity792>
    fun findByField3GreaterThan(value: Int): List<Entity792>
}

@Service
@Transactional
class Service792(private val repo: Entity792Repository) {
    fun findAll(): List<Entity792> = repo.findAll()
    fun findByName(name: String): List<Entity792> = repo.findByField1(name)
    fun save(entity: Entity792): Entity792 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity792>): List<Entity792> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
