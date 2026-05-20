package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_313")
data class Entity313(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity313Repository : org.springframework.data.jpa.repository.JpaRepository<Entity313, Long> {
    fun findByField1(field1: String): List<Entity313>
    fun findByField3GreaterThan(value: Int): List<Entity313>
}

@Service
@Transactional
class Service313(private val repo: Entity313Repository) {
    fun findAll(): List<Entity313> = repo.findAll()
    fun findByName(name: String): List<Entity313> = repo.findByField1(name)
    fun save(entity: Entity313): Entity313 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity313>): List<Entity313> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
