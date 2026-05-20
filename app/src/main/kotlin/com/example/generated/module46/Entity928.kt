package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_928")
data class Entity928(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity928Repository : org.springframework.data.jpa.repository.JpaRepository<Entity928, Long> {
    fun findByField1(field1: String): List<Entity928>
    fun findByField3GreaterThan(value: Int): List<Entity928>
}

@Service
@Transactional
class Service928(private val repo: Entity928Repository) {
    fun findAll(): List<Entity928> = repo.findAll()
    fun findByName(name: String): List<Entity928> = repo.findByField1(name)
    fun save(entity: Entity928): Entity928 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity928>): List<Entity928> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
