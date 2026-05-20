package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_508")
data class Entity508(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity508Repository : org.springframework.data.jpa.repository.JpaRepository<Entity508, Long> {
    fun findByField1(field1: String): List<Entity508>
    fun findByField3GreaterThan(value: Int): List<Entity508>
}

@Service
@Transactional
class Service508(private val repo: Entity508Repository) {
    fun findAll(): List<Entity508> = repo.findAll()
    fun findByName(name: String): List<Entity508> = repo.findByField1(name)
    fun save(entity: Entity508): Entity508 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity508>): List<Entity508> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
