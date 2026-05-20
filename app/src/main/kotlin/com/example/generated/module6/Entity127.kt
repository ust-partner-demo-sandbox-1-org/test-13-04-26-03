package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_127")
data class Entity127(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity127Repository : org.springframework.data.jpa.repository.JpaRepository<Entity127, Long> {
    fun findByField1(field1: String): List<Entity127>
    fun findByField3GreaterThan(value: Int): List<Entity127>
}

@Service
@Transactional
class Service127(private val repo: Entity127Repository) {
    fun findAll(): List<Entity127> = repo.findAll()
    fun findByName(name: String): List<Entity127> = repo.findByField1(name)
    fun save(entity: Entity127): Entity127 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity127>): List<Entity127> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
