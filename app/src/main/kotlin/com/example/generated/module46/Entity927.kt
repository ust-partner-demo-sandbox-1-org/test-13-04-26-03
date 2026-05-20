package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_927")
data class Entity927(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity927Repository : org.springframework.data.jpa.repository.JpaRepository<Entity927, Long> {
    fun findByField1(field1: String): List<Entity927>
    fun findByField3GreaterThan(value: Int): List<Entity927>
}

@Service
@Transactional
class Service927(private val repo: Entity927Repository) {
    fun findAll(): List<Entity927> = repo.findAll()
    fun findByName(name: String): List<Entity927> = repo.findByField1(name)
    fun save(entity: Entity927): Entity927 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity927>): List<Entity927> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
