package com.example.generated.module8

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_166")
data class Entity166(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity166Repository : org.springframework.data.jpa.repository.JpaRepository<Entity166, Long> {
    fun findByField1(field1: String): List<Entity166>
    fun findByField3GreaterThan(value: Int): List<Entity166>
}

@Service
@Transactional
class Service166(private val repo: Entity166Repository) {
    fun findAll(): List<Entity166> = repo.findAll()
    fun findByName(name: String): List<Entity166> = repo.findByField1(name)
    fun save(entity: Entity166): Entity166 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity166>): List<Entity166> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
