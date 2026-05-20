package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_147")
data class Entity147(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity147Repository : org.springframework.data.jpa.repository.JpaRepository<Entity147, Long> {
    fun findByField1(field1: String): List<Entity147>
    fun findByField3GreaterThan(value: Int): List<Entity147>
}

@Service
@Transactional
class Service147(private val repo: Entity147Repository) {
    fun findAll(): List<Entity147> = repo.findAll()
    fun findByName(name: String): List<Entity147> = repo.findByField1(name)
    fun save(entity: Entity147): Entity147 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity147>): List<Entity147> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
