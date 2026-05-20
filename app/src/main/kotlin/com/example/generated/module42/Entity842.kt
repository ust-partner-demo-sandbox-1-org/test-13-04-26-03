package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_842")
data class Entity842(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity842Repository : org.springframework.data.jpa.repository.JpaRepository<Entity842, Long> {
    fun findByField1(field1: String): List<Entity842>
    fun findByField3GreaterThan(value: Int): List<Entity842>
}

@Service
@Transactional
class Service842(private val repo: Entity842Repository) {
    fun findAll(): List<Entity842> = repo.findAll()
    fun findByName(name: String): List<Entity842> = repo.findByField1(name)
    fun save(entity: Entity842): Entity842 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity842>): List<Entity842> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
