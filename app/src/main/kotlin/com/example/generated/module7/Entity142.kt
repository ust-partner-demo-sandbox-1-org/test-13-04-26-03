package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_142")
data class Entity142(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity142Repository : org.springframework.data.jpa.repository.JpaRepository<Entity142, Long> {
    fun findByField1(field1: String): List<Entity142>
    fun findByField3GreaterThan(value: Int): List<Entity142>
}

@Service
@Transactional
class Service142(private val repo: Entity142Repository) {
    fun findAll(): List<Entity142> = repo.findAll()
    fun findByName(name: String): List<Entity142> = repo.findByField1(name)
    fun save(entity: Entity142): Entity142 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity142>): List<Entity142> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
