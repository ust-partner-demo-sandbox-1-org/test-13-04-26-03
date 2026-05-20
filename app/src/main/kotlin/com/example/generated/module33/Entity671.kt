package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_671")
data class Entity671(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity671Repository : org.springframework.data.jpa.repository.JpaRepository<Entity671, Long> {
    fun findByField1(field1: String): List<Entity671>
    fun findByField3GreaterThan(value: Int): List<Entity671>
}

@Service
@Transactional
class Service671(private val repo: Entity671Repository) {
    fun findAll(): List<Entity671> = repo.findAll()
    fun findByName(name: String): List<Entity671> = repo.findByField1(name)
    fun save(entity: Entity671): Entity671 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity671>): List<Entity671> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
