package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_797")
data class Entity797(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity797Repository : org.springframework.data.jpa.repository.JpaRepository<Entity797, Long> {
    fun findByField1(field1: String): List<Entity797>
    fun findByField3GreaterThan(value: Int): List<Entity797>
}

@Service
@Transactional
class Service797(private val repo: Entity797Repository) {
    fun findAll(): List<Entity797> = repo.findAll()
    fun findByName(name: String): List<Entity797> = repo.findByField1(name)
    fun save(entity: Entity797): Entity797 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity797>): List<Entity797> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
