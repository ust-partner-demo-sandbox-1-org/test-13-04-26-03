package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_52")
data class Entity52(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity52Repository : org.springframework.data.jpa.repository.JpaRepository<Entity52, Long> {
    fun findByField1(field1: String): List<Entity52>
    fun findByField3GreaterThan(value: Int): List<Entity52>
}

@Service
@Transactional
class Service52(private val repo: Entity52Repository) {
    fun findAll(): List<Entity52> = repo.findAll()
    fun findByName(name: String): List<Entity52> = repo.findByField1(name)
    fun save(entity: Entity52): Entity52 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity52>): List<Entity52> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
