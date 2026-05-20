package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_702")
data class Entity702(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity702Repository : org.springframework.data.jpa.repository.JpaRepository<Entity702, Long> {
    fun findByField1(field1: String): List<Entity702>
    fun findByField3GreaterThan(value: Int): List<Entity702>
}

@Service
@Transactional
class Service702(private val repo: Entity702Repository) {
    fun findAll(): List<Entity702> = repo.findAll()
    fun findByName(name: String): List<Entity702> = repo.findByField1(name)
    fun save(entity: Entity702): Entity702 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity702>): List<Entity702> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
