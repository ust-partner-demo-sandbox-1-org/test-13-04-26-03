package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_920")
data class Entity920(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity920Repository : org.springframework.data.jpa.repository.JpaRepository<Entity920, Long> {
    fun findByField1(field1: String): List<Entity920>
    fun findByField3GreaterThan(value: Int): List<Entity920>
}

@Service
@Transactional
class Service920(private val repo: Entity920Repository) {
    fun findAll(): List<Entity920> = repo.findAll()
    fun findByName(name: String): List<Entity920> = repo.findByField1(name)
    fun save(entity: Entity920): Entity920 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity920>): List<Entity920> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
