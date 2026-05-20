package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_811")
data class Entity811(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity811Repository : org.springframework.data.jpa.repository.JpaRepository<Entity811, Long> {
    fun findByField1(field1: String): List<Entity811>
    fun findByField3GreaterThan(value: Int): List<Entity811>
}

@Service
@Transactional
class Service811(private val repo: Entity811Repository) {
    fun findAll(): List<Entity811> = repo.findAll()
    fun findByName(name: String): List<Entity811> = repo.findByField1(name)
    fun save(entity: Entity811): Entity811 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity811>): List<Entity811> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
