package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_791")
data class Entity791(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity791Repository : org.springframework.data.jpa.repository.JpaRepository<Entity791, Long> {
    fun findByField1(field1: String): List<Entity791>
    fun findByField3GreaterThan(value: Int): List<Entity791>
}

@Service
@Transactional
class Service791(private val repo: Entity791Repository) {
    fun findAll(): List<Entity791> = repo.findAll()
    fun findByName(name: String): List<Entity791> = repo.findByField1(name)
    fun save(entity: Entity791): Entity791 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity791>): List<Entity791> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
