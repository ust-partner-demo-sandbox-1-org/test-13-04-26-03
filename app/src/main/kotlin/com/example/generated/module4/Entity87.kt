package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_87")
data class Entity87(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity87Repository : org.springframework.data.jpa.repository.JpaRepository<Entity87, Long> {
    fun findByField1(field1: String): List<Entity87>
    fun findByField3GreaterThan(value: Int): List<Entity87>
}

@Service
@Transactional
class Service87(private val repo: Entity87Repository) {
    fun findAll(): List<Entity87> = repo.findAll()
    fun findByName(name: String): List<Entity87> = repo.findByField1(name)
    fun save(entity: Entity87): Entity87 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity87>): List<Entity87> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
