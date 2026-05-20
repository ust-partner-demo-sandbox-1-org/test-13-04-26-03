package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_527")
data class Entity527(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity527Repository : org.springframework.data.jpa.repository.JpaRepository<Entity527, Long> {
    fun findByField1(field1: String): List<Entity527>
    fun findByField3GreaterThan(value: Int): List<Entity527>
}

@Service
@Transactional
class Service527(private val repo: Entity527Repository) {
    fun findAll(): List<Entity527> = repo.findAll()
    fun findByName(name: String): List<Entity527> = repo.findByField1(name)
    fun save(entity: Entity527): Entity527 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity527>): List<Entity527> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
