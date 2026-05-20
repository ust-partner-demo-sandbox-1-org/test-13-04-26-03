package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_491")
data class Entity491(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity491Repository : org.springframework.data.jpa.repository.JpaRepository<Entity491, Long> {
    fun findByField1(field1: String): List<Entity491>
    fun findByField3GreaterThan(value: Int): List<Entity491>
}

@Service
@Transactional
class Service491(private val repo: Entity491Repository) {
    fun findAll(): List<Entity491> = repo.findAll()
    fun findByName(name: String): List<Entity491> = repo.findByField1(name)
    fun save(entity: Entity491): Entity491 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity491>): List<Entity491> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
