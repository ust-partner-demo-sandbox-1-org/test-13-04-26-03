package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_352")
data class Entity352(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity352Repository : org.springframework.data.jpa.repository.JpaRepository<Entity352, Long> {
    fun findByField1(field1: String): List<Entity352>
    fun findByField3GreaterThan(value: Int): List<Entity352>
}

@Service
@Transactional
class Service352(private val repo: Entity352Repository) {
    fun findAll(): List<Entity352> = repo.findAll()
    fun findByName(name: String): List<Entity352> = repo.findByField1(name)
    fun save(entity: Entity352): Entity352 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity352>): List<Entity352> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
