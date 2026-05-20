package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_64")
data class Entity64(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity64Repository : org.springframework.data.jpa.repository.JpaRepository<Entity64, Long> {
    fun findByField1(field1: String): List<Entity64>
    fun findByField3GreaterThan(value: Int): List<Entity64>
}

@Service
@Transactional
class Service64(private val repo: Entity64Repository) {
    fun findAll(): List<Entity64> = repo.findAll()
    fun findByName(name: String): List<Entity64> = repo.findByField1(name)
    fun save(entity: Entity64): Entity64 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity64>): List<Entity64> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
