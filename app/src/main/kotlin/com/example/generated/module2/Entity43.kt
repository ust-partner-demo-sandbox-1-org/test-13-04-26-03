package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_43")
data class Entity43(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity43Repository : org.springframework.data.jpa.repository.JpaRepository<Entity43, Long> {
    fun findByField1(field1: String): List<Entity43>
    fun findByField3GreaterThan(value: Int): List<Entity43>
}

@Service
@Transactional
class Service43(private val repo: Entity43Repository) {
    fun findAll(): List<Entity43> = repo.findAll()
    fun findByName(name: String): List<Entity43> = repo.findByField1(name)
    fun save(entity: Entity43): Entity43 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity43>): List<Entity43> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
