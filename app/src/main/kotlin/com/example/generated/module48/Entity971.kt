package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_971")
data class Entity971(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity971Repository : org.springframework.data.jpa.repository.JpaRepository<Entity971, Long> {
    fun findByField1(field1: String): List<Entity971>
    fun findByField3GreaterThan(value: Int): List<Entity971>
}

@Service
@Transactional
class Service971(private val repo: Entity971Repository) {
    fun findAll(): List<Entity971> = repo.findAll()
    fun findByName(name: String): List<Entity971> = repo.findByField1(name)
    fun save(entity: Entity971): Entity971 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity971>): List<Entity971> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
