package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_293")
data class Entity293(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity293Repository : org.springframework.data.jpa.repository.JpaRepository<Entity293, Long> {
    fun findByField1(field1: String): List<Entity293>
    fun findByField3GreaterThan(value: Int): List<Entity293>
}

@Service
@Transactional
class Service293(private val repo: Entity293Repository) {
    fun findAll(): List<Entity293> = repo.findAll()
    fun findByName(name: String): List<Entity293> = repo.findByField1(name)
    fun save(entity: Entity293): Entity293 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity293>): List<Entity293> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
