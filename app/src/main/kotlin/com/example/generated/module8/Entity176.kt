package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_176")
data class Entity176(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity176Repository : org.springframework.data.jpa.repository.JpaRepository<Entity176, Long> {
    fun findByField1(field1: String): List<Entity176>
    fun findByField3GreaterThan(value: Int): List<Entity176>
}

@Service
@Transactional
class Service176(private val repo: Entity176Repository) {
    fun findAll(): List<Entity176> = repo.findAll()
    fun findByName(name: String): List<Entity176> = repo.findByField1(name)
    fun save(entity: Entity176): Entity176 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity176>): List<Entity176> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
