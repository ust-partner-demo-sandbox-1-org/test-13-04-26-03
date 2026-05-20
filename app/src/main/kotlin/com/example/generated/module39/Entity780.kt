package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_780")
data class Entity780(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity780Repository : org.springframework.data.jpa.repository.JpaRepository<Entity780, Long> {
    fun findByField1(field1: String): List<Entity780>
    fun findByField3GreaterThan(value: Int): List<Entity780>
}

@Service
@Transactional
class Service780(private val repo: Entity780Repository) {
    fun findAll(): List<Entity780> = repo.findAll()
    fun findByName(name: String): List<Entity780> = repo.findByField1(name)
    fun save(entity: Entity780): Entity780 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity780>): List<Entity780> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
