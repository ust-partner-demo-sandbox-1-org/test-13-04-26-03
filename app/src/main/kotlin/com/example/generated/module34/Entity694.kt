package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_694")
data class Entity694(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity694Repository : org.springframework.data.jpa.repository.JpaRepository<Entity694, Long> {
    fun findByField1(field1: String): List<Entity694>
    fun findByField3GreaterThan(value: Int): List<Entity694>
}

@Service
@Transactional
class Service694(private val repo: Entity694Repository) {
    fun findAll(): List<Entity694> = repo.findAll()
    fun findByName(name: String): List<Entity694> = repo.findByField1(name)
    fun save(entity: Entity694): Entity694 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity694>): List<Entity694> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
