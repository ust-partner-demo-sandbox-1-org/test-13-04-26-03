package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_141")
data class Entity141(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity141Repository : org.springframework.data.jpa.repository.JpaRepository<Entity141, Long> {
    fun findByField1(field1: String): List<Entity141>
    fun findByField3GreaterThan(value: Int): List<Entity141>
}

@Service
@Transactional
class Service141(private val repo: Entity141Repository) {
    fun findAll(): List<Entity141> = repo.findAll()
    fun findByName(name: String): List<Entity141> = repo.findByField1(name)
    fun save(entity: Entity141): Entity141 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity141>): List<Entity141> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
