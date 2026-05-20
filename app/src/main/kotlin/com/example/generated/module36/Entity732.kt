package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_732")
data class Entity732(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity732Repository : org.springframework.data.jpa.repository.JpaRepository<Entity732, Long> {
    fun findByField1(field1: String): List<Entity732>
    fun findByField3GreaterThan(value: Int): List<Entity732>
}

@Service
@Transactional
class Service732(private val repo: Entity732Repository) {
    fun findAll(): List<Entity732> = repo.findAll()
    fun findByName(name: String): List<Entity732> = repo.findByField1(name)
    fun save(entity: Entity732): Entity732 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity732>): List<Entity732> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
