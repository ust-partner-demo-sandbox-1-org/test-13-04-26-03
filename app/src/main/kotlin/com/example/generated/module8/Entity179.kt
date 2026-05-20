package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_179")
data class Entity179(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity179Repository : org.springframework.data.jpa.repository.JpaRepository<Entity179, Long> {
    fun findByField1(field1: String): List<Entity179>
    fun findByField3GreaterThan(value: Int): List<Entity179>
}

@Service
@Transactional
class Service179(private val repo: Entity179Repository) {
    fun findAll(): List<Entity179> = repo.findAll()
    fun findByName(name: String): List<Entity179> = repo.findByField1(name)
    fun save(entity: Entity179): Entity179 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity179>): List<Entity179> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
