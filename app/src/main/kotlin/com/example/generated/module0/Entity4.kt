package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_4")
data class Entity4(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity4Repository : org.springframework.data.jpa.repository.JpaRepository<Entity4, Long> {
    fun findByField1(field1: String): List<Entity4>
    fun findByField3GreaterThan(value: Int): List<Entity4>
}

@Service
@Transactional
class Service4(private val repo: Entity4Repository) {
    fun findAll(): List<Entity4> = repo.findAll()
    fun findByName(name: String): List<Entity4> = repo.findByField1(name)
    fun save(entity: Entity4): Entity4 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity4>): List<Entity4> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
