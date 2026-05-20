package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_574")
data class Entity574(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity574Repository : org.springframework.data.jpa.repository.JpaRepository<Entity574, Long> {
    fun findByField1(field1: String): List<Entity574>
    fun findByField3GreaterThan(value: Int): List<Entity574>
}

@Service
@Transactional
class Service574(private val repo: Entity574Repository) {
    fun findAll(): List<Entity574> = repo.findAll()
    fun findByName(name: String): List<Entity574> = repo.findByField1(name)
    fun save(entity: Entity574): Entity574 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity574>): List<Entity574> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
