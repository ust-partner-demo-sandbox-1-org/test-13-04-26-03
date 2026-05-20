package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_550")
data class Entity550(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity550Repository : org.springframework.data.jpa.repository.JpaRepository<Entity550, Long> {
    fun findByField1(field1: String): List<Entity550>
    fun findByField3GreaterThan(value: Int): List<Entity550>
}

@Service
@Transactional
class Service550(private val repo: Entity550Repository) {
    fun findAll(): List<Entity550> = repo.findAll()
    fun findByName(name: String): List<Entity550> = repo.findByField1(name)
    fun save(entity: Entity550): Entity550 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity550>): List<Entity550> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
