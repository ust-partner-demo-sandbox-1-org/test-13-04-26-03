package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_102")
data class Entity102(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity102Repository : org.springframework.data.jpa.repository.JpaRepository<Entity102, Long> {
    fun findByField1(field1: String): List<Entity102>
    fun findByField3GreaterThan(value: Int): List<Entity102>
}

@Service
@Transactional
class Service102(private val repo: Entity102Repository) {
    fun findAll(): List<Entity102> = repo.findAll()
    fun findByName(name: String): List<Entity102> = repo.findByField1(name)
    fun save(entity: Entity102): Entity102 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity102>): List<Entity102> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
