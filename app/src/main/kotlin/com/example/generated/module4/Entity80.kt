package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_80")
data class Entity80(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity80Repository : org.springframework.data.jpa.repository.JpaRepository<Entity80, Long> {
    fun findByField1(field1: String): List<Entity80>
    fun findByField3GreaterThan(value: Int): List<Entity80>
}

@Service
@Transactional
class Service80(private val repo: Entity80Repository) {
    fun findAll(): List<Entity80> = repo.findAll()
    fun findByName(name: String): List<Entity80> = repo.findByField1(name)
    fun save(entity: Entity80): Entity80 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity80>): List<Entity80> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
