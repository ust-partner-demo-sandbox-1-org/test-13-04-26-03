package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_545")
data class Entity545(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity545Repository : org.springframework.data.jpa.repository.JpaRepository<Entity545, Long> {
    fun findByField1(field1: String): List<Entity545>
    fun findByField3GreaterThan(value: Int): List<Entity545>
}

@Service
@Transactional
class Service545(private val repo: Entity545Repository) {
    fun findAll(): List<Entity545> = repo.findAll()
    fun findByName(name: String): List<Entity545> = repo.findByField1(name)
    fun save(entity: Entity545): Entity545 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity545>): List<Entity545> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
