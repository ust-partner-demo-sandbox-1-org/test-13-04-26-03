package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_362")
data class Entity362(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity362Repository : org.springframework.data.jpa.repository.JpaRepository<Entity362, Long> {
    fun findByField1(field1: String): List<Entity362>
    fun findByField3GreaterThan(value: Int): List<Entity362>
}

@Service
@Transactional
class Service362(private val repo: Entity362Repository) {
    fun findAll(): List<Entity362> = repo.findAll()
    fun findByName(name: String): List<Entity362> = repo.findByField1(name)
    fun save(entity: Entity362): Entity362 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity362>): List<Entity362> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
