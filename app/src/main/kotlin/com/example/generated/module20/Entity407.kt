package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_407")
data class Entity407(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity407Repository : org.springframework.data.jpa.repository.JpaRepository<Entity407, Long> {
    fun findByField1(field1: String): List<Entity407>
    fun findByField3GreaterThan(value: Int): List<Entity407>
}

@Service
@Transactional
class Service407(private val repo: Entity407Repository) {
    fun findAll(): List<Entity407> = repo.findAll()
    fun findByName(name: String): List<Entity407> = repo.findByField1(name)
    fun save(entity: Entity407): Entity407 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity407>): List<Entity407> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
