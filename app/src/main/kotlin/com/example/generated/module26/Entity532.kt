package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_532")
data class Entity532(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity532Repository : org.springframework.data.jpa.repository.JpaRepository<Entity532, Long> {
    fun findByField1(field1: String): List<Entity532>
    fun findByField3GreaterThan(value: Int): List<Entity532>
}

@Service
@Transactional
class Service532(private val repo: Entity532Repository) {
    fun findAll(): List<Entity532> = repo.findAll()
    fun findByName(name: String): List<Entity532> = repo.findByField1(name)
    fun save(entity: Entity532): Entity532 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity532>): List<Entity532> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
