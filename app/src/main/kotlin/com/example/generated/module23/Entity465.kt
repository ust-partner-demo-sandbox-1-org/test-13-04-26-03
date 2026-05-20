package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_465")
data class Entity465(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity465Repository : org.springframework.data.jpa.repository.JpaRepository<Entity465, Long> {
    fun findByField1(field1: String): List<Entity465>
    fun findByField3GreaterThan(value: Int): List<Entity465>
}

@Service
@Transactional
class Service465(private val repo: Entity465Repository) {
    fun findAll(): List<Entity465> = repo.findAll()
    fun findByName(name: String): List<Entity465> = repo.findByField1(name)
    fun save(entity: Entity465): Entity465 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity465>): List<Entity465> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
