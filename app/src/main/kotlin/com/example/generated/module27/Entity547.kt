package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_547")
data class Entity547(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity547Repository : org.springframework.data.jpa.repository.JpaRepository<Entity547, Long> {
    fun findByField1(field1: String): List<Entity547>
    fun findByField3GreaterThan(value: Int): List<Entity547>
}

@Service
@Transactional
class Service547(private val repo: Entity547Repository) {
    fun findAll(): List<Entity547> = repo.findAll()
    fun findByName(name: String): List<Entity547> = repo.findByField1(name)
    fun save(entity: Entity547): Entity547 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity547>): List<Entity547> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
