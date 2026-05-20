package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_908")
data class Entity908(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity908Repository : org.springframework.data.jpa.repository.JpaRepository<Entity908, Long> {
    fun findByField1(field1: String): List<Entity908>
    fun findByField3GreaterThan(value: Int): List<Entity908>
}

@Service
@Transactional
class Service908(private val repo: Entity908Repository) {
    fun findAll(): List<Entity908> = repo.findAll()
    fun findByName(name: String): List<Entity908> = repo.findByField1(name)
    fun save(entity: Entity908): Entity908 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity908>): List<Entity908> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
