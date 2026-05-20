package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_798")
data class Entity798(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity798Repository : org.springframework.data.jpa.repository.JpaRepository<Entity798, Long> {
    fun findByField1(field1: String): List<Entity798>
    fun findByField3GreaterThan(value: Int): List<Entity798>
}

@Service
@Transactional
class Service798(private val repo: Entity798Repository) {
    fun findAll(): List<Entity798> = repo.findAll()
    fun findByName(name: String): List<Entity798> = repo.findByField1(name)
    fun save(entity: Entity798): Entity798 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity798>): List<Entity798> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
