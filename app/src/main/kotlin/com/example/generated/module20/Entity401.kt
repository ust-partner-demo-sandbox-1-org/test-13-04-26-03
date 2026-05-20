package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_401")
data class Entity401(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity401Repository : org.springframework.data.jpa.repository.JpaRepository<Entity401, Long> {
    fun findByField1(field1: String): List<Entity401>
    fun findByField3GreaterThan(value: Int): List<Entity401>
}

@Service
@Transactional
class Service401(private val repo: Entity401Repository) {
    fun findAll(): List<Entity401> = repo.findAll()
    fun findByName(name: String): List<Entity401> = repo.findByField1(name)
    fun save(entity: Entity401): Entity401 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity401>): List<Entity401> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
