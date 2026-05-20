package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_12")
data class Entity12(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity12Repository : org.springframework.data.jpa.repository.JpaRepository<Entity12, Long> {
    fun findByField1(field1: String): List<Entity12>
    fun findByField3GreaterThan(value: Int): List<Entity12>
}

@Service
@Transactional
class Service12(private val repo: Entity12Repository) {
    fun findAll(): List<Entity12> = repo.findAll()
    fun findByName(name: String): List<Entity12> = repo.findByField1(name)
    fun save(entity: Entity12): Entity12 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity12>): List<Entity12> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
