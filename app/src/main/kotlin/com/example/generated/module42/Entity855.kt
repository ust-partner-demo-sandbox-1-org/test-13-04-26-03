package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_855")
data class Entity855(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity855Repository : org.springframework.data.jpa.repository.JpaRepository<Entity855, Long> {
    fun findByField1(field1: String): List<Entity855>
    fun findByField3GreaterThan(value: Int): List<Entity855>
}

@Service
@Transactional
class Service855(private val repo: Entity855Repository) {
    fun findAll(): List<Entity855> = repo.findAll()
    fun findByName(name: String): List<Entity855> = repo.findByField1(name)
    fun save(entity: Entity855): Entity855 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity855>): List<Entity855> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
