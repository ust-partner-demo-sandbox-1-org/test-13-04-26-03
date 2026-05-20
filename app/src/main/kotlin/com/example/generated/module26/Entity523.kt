package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_523")
data class Entity523(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity523Repository : org.springframework.data.jpa.repository.JpaRepository<Entity523, Long> {
    fun findByField1(field1: String): List<Entity523>
    fun findByField3GreaterThan(value: Int): List<Entity523>
}

@Service
@Transactional
class Service523(private val repo: Entity523Repository) {
    fun findAll(): List<Entity523> = repo.findAll()
    fun findByName(name: String): List<Entity523> = repo.findByField1(name)
    fun save(entity: Entity523): Entity523 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity523>): List<Entity523> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
