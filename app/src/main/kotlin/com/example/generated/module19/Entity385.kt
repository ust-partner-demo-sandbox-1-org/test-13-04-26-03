package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_385")
data class Entity385(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity385Repository : org.springframework.data.jpa.repository.JpaRepository<Entity385, Long> {
    fun findByField1(field1: String): List<Entity385>
    fun findByField3GreaterThan(value: Int): List<Entity385>
}

@Service
@Transactional
class Service385(private val repo: Entity385Repository) {
    fun findAll(): List<Entity385> = repo.findAll()
    fun findByName(name: String): List<Entity385> = repo.findByField1(name)
    fun save(entity: Entity385): Entity385 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity385>): List<Entity385> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
