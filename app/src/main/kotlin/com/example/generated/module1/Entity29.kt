package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_29")
data class Entity29(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity29Repository : org.springframework.data.jpa.repository.JpaRepository<Entity29, Long> {
    fun findByField1(field1: String): List<Entity29>
    fun findByField3GreaterThan(value: Int): List<Entity29>
}

@Service
@Transactional
class Service29(private val repo: Entity29Repository) {
    fun findAll(): List<Entity29> = repo.findAll()
    fun findByName(name: String): List<Entity29> = repo.findByField1(name)
    fun save(entity: Entity29): Entity29 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity29>): List<Entity29> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
