package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_134")
data class Entity134(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity134Repository : org.springframework.data.jpa.repository.JpaRepository<Entity134, Long> {
    fun findByField1(field1: String): List<Entity134>
    fun findByField3GreaterThan(value: Int): List<Entity134>
}

@Service
@Transactional
class Service134(private val repo: Entity134Repository) {
    fun findAll(): List<Entity134> = repo.findAll()
    fun findByName(name: String): List<Entity134> = repo.findByField1(name)
    fun save(entity: Entity134): Entity134 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity134>): List<Entity134> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
