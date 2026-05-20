package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_128")
data class Entity128(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity128Repository : org.springframework.data.jpa.repository.JpaRepository<Entity128, Long> {
    fun findByField1(field1: String): List<Entity128>
    fun findByField3GreaterThan(value: Int): List<Entity128>
}

@Service
@Transactional
class Service128(private val repo: Entity128Repository) {
    fun findAll(): List<Entity128> = repo.findAll()
    fun findByName(name: String): List<Entity128> = repo.findByField1(name)
    fun save(entity: Entity128): Entity128 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity128>): List<Entity128> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
