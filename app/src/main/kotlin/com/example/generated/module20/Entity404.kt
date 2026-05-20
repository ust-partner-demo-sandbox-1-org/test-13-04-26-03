package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_404")
data class Entity404(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity404Repository : org.springframework.data.jpa.repository.JpaRepository<Entity404, Long> {
    fun findByField1(field1: String): List<Entity404>
    fun findByField3GreaterThan(value: Int): List<Entity404>
}

@Service
@Transactional
class Service404(private val repo: Entity404Repository) {
    fun findAll(): List<Entity404> = repo.findAll()
    fun findByName(name: String): List<Entity404> = repo.findByField1(name)
    fun save(entity: Entity404): Entity404 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity404>): List<Entity404> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
