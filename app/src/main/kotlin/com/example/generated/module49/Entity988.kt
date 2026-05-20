package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_988")
data class Entity988(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity988Repository : org.springframework.data.jpa.repository.JpaRepository<Entity988, Long> {
    fun findByField1(field1: String): List<Entity988>
    fun findByField3GreaterThan(value: Int): List<Entity988>
}

@Service
@Transactional
class Service988(private val repo: Entity988Repository) {
    fun findAll(): List<Entity988> = repo.findAll()
    fun findByName(name: String): List<Entity988> = repo.findByField1(name)
    fun save(entity: Entity988): Entity988 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity988>): List<Entity988> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
