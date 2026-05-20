package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_146")
data class Entity146(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity146Repository : org.springframework.data.jpa.repository.JpaRepository<Entity146, Long> {
    fun findByField1(field1: String): List<Entity146>
    fun findByField3GreaterThan(value: Int): List<Entity146>
}

@Service
@Transactional
class Service146(private val repo: Entity146Repository) {
    fun findAll(): List<Entity146> = repo.findAll()
    fun findByName(name: String): List<Entity146> = repo.findByField1(name)
    fun save(entity: Entity146): Entity146 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity146>): List<Entity146> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
