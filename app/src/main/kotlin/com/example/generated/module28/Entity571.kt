package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_571")
data class Entity571(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity571Repository : org.springframework.data.jpa.repository.JpaRepository<Entity571, Long> {
    fun findByField1(field1: String): List<Entity571>
    fun findByField3GreaterThan(value: Int): List<Entity571>
}

@Service
@Transactional
class Service571(private val repo: Entity571Repository) {
    fun findAll(): List<Entity571> = repo.findAll()
    fun findByName(name: String): List<Entity571> = repo.findByField1(name)
    fun save(entity: Entity571): Entity571 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity571>): List<Entity571> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
