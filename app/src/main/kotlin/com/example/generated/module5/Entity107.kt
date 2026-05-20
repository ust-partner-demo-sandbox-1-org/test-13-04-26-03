package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_107")
data class Entity107(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity107Repository : org.springframework.data.jpa.repository.JpaRepository<Entity107, Long> {
    fun findByField1(field1: String): List<Entity107>
    fun findByField3GreaterThan(value: Int): List<Entity107>
}

@Service
@Transactional
class Service107(private val repo: Entity107Repository) {
    fun findAll(): List<Entity107> = repo.findAll()
    fun findByName(name: String): List<Entity107> = repo.findByField1(name)
    fun save(entity: Entity107): Entity107 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity107>): List<Entity107> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
