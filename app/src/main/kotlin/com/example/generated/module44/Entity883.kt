package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_883")
data class Entity883(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity883Repository : org.springframework.data.jpa.repository.JpaRepository<Entity883, Long> {
    fun findByField1(field1: String): List<Entity883>
    fun findByField3GreaterThan(value: Int): List<Entity883>
}

@Service
@Transactional
class Service883(private val repo: Entity883Repository) {
    fun findAll(): List<Entity883> = repo.findAll()
    fun findByName(name: String): List<Entity883> = repo.findByField1(name)
    fun save(entity: Entity883): Entity883 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity883>): List<Entity883> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
