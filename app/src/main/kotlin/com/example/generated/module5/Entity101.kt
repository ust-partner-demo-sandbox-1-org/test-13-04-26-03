package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_101")
data class Entity101(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity101Repository : org.springframework.data.jpa.repository.JpaRepository<Entity101, Long> {
    fun findByField1(field1: String): List<Entity101>
    fun findByField3GreaterThan(value: Int): List<Entity101>
}

@Service
@Transactional
class Service101(private val repo: Entity101Repository) {
    fun findAll(): List<Entity101> = repo.findAll()
    fun findByName(name: String): List<Entity101> = repo.findByField1(name)
    fun save(entity: Entity101): Entity101 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity101>): List<Entity101> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
