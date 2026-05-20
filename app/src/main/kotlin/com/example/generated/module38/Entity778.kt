package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_778")
data class Entity778(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity778Repository : org.springframework.data.jpa.repository.JpaRepository<Entity778, Long> {
    fun findByField1(field1: String): List<Entity778>
    fun findByField3GreaterThan(value: Int): List<Entity778>
}

@Service
@Transactional
class Service778(private val repo: Entity778Repository) {
    fun findAll(): List<Entity778> = repo.findAll()
    fun findByName(name: String): List<Entity778> = repo.findByField1(name)
    fun save(entity: Entity778): Entity778 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity778>): List<Entity778> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
