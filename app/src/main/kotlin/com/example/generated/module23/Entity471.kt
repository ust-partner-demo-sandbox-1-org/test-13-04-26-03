package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_471")
data class Entity471(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity471Repository : org.springframework.data.jpa.repository.JpaRepository<Entity471, Long> {
    fun findByField1(field1: String): List<Entity471>
    fun findByField3GreaterThan(value: Int): List<Entity471>
}

@Service
@Transactional
class Service471(private val repo: Entity471Repository) {
    fun findAll(): List<Entity471> = repo.findAll()
    fun findByName(name: String): List<Entity471> = repo.findByField1(name)
    fun save(entity: Entity471): Entity471 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity471>): List<Entity471> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
