package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_990")
data class Entity990(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity990Repository : org.springframework.data.jpa.repository.JpaRepository<Entity990, Long> {
    fun findByField1(field1: String): List<Entity990>
    fun findByField3GreaterThan(value: Int): List<Entity990>
}

@Service
@Transactional
class Service990(private val repo: Entity990Repository) {
    fun findAll(): List<Entity990> = repo.findAll()
    fun findByName(name: String): List<Entity990> = repo.findByField1(name)
    fun save(entity: Entity990): Entity990 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity990>): List<Entity990> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
