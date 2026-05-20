package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_124")
data class Entity124(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity124Repository : org.springframework.data.jpa.repository.JpaRepository<Entity124, Long> {
    fun findByField1(field1: String): List<Entity124>
    fun findByField3GreaterThan(value: Int): List<Entity124>
}

@Service
@Transactional
class Service124(private val repo: Entity124Repository) {
    fun findAll(): List<Entity124> = repo.findAll()
    fun findByName(name: String): List<Entity124> = repo.findByField1(name)
    fun save(entity: Entity124): Entity124 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity124>): List<Entity124> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
