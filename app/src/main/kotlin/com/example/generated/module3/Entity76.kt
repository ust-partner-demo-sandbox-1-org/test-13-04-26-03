package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_76")
data class Entity76(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity76Repository : org.springframework.data.jpa.repository.JpaRepository<Entity76, Long> {
    fun findByField1(field1: String): List<Entity76>
    fun findByField3GreaterThan(value: Int): List<Entity76>
}

@Service
@Transactional
class Service76(private val repo: Entity76Repository) {
    fun findAll(): List<Entity76> = repo.findAll()
    fun findByName(name: String): List<Entity76> = repo.findByField1(name)
    fun save(entity: Entity76): Entity76 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity76>): List<Entity76> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
