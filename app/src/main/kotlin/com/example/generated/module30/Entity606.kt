package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_606")
data class Entity606(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity606Repository : org.springframework.data.jpa.repository.JpaRepository<Entity606, Long> {
    fun findByField1(field1: String): List<Entity606>
    fun findByField3GreaterThan(value: Int): List<Entity606>
}

@Service
@Transactional
class Service606(private val repo: Entity606Repository) {
    fun findAll(): List<Entity606> = repo.findAll()
    fun findByName(name: String): List<Entity606> = repo.findByField1(name)
    fun save(entity: Entity606): Entity606 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity606>): List<Entity606> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
