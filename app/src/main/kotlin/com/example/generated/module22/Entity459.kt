package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_459")
data class Entity459(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity459Repository : org.springframework.data.jpa.repository.JpaRepository<Entity459, Long> {
    fun findByField1(field1: String): List<Entity459>
    fun findByField3GreaterThan(value: Int): List<Entity459>
}

@Service
@Transactional
class Service459(private val repo: Entity459Repository) {
    fun findAll(): List<Entity459> = repo.findAll()
    fun findByName(name: String): List<Entity459> = repo.findByField1(name)
    fun save(entity: Entity459): Entity459 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity459>): List<Entity459> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
