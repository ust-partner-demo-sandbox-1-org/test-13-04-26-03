package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_265")
data class Entity265(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity265Repository : org.springframework.data.jpa.repository.JpaRepository<Entity265, Long> {
    fun findByField1(field1: String): List<Entity265>
    fun findByField3GreaterThan(value: Int): List<Entity265>
}

@Service
@Transactional
class Service265(private val repo: Entity265Repository) {
    fun findAll(): List<Entity265> = repo.findAll()
    fun findByName(name: String): List<Entity265> = repo.findByField1(name)
    fun save(entity: Entity265): Entity265 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity265>): List<Entity265> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
