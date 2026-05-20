package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_5")
data class Entity5(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity5Repository : org.springframework.data.jpa.repository.JpaRepository<Entity5, Long> {
    fun findByField1(field1: String): List<Entity5>
    fun findByField3GreaterThan(value: Int): List<Entity5>
}

@Service
@Transactional
class Service5(private val repo: Entity5Repository) {
    fun findAll(): List<Entity5> = repo.findAll()
    fun findByName(name: String): List<Entity5> = repo.findByField1(name)
    fun save(entity: Entity5): Entity5 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity5>): List<Entity5> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
