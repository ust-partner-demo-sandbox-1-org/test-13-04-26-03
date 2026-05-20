package com.example.generated.module17

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_347")
data class Entity347(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity347Repository : org.springframework.data.jpa.repository.JpaRepository<Entity347, Long> {
    fun findByField1(field1: String): List<Entity347>
    fun findByField3GreaterThan(value: Int): List<Entity347>
}

@Service
@Transactional
class Service347(private val repo: Entity347Repository) {
    fun findAll(): List<Entity347> = repo.findAll()
    fun findByName(name: String): List<Entity347> = repo.findByField1(name)
    fun save(entity: Entity347): Entity347 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity347>): List<Entity347> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
