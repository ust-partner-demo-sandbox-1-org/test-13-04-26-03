package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_356")
data class Entity356(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity356Repository : org.springframework.data.jpa.repository.JpaRepository<Entity356, Long> {
    fun findByField1(field1: String): List<Entity356>
    fun findByField3GreaterThan(value: Int): List<Entity356>
}

@Service
@Transactional
class Service356(private val repo: Entity356Repository) {
    fun findAll(): List<Entity356> = repo.findAll()
    fun findByName(name: String): List<Entity356> = repo.findByField1(name)
    fun save(entity: Entity356): Entity356 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity356>): List<Entity356> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
