package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_982")
data class Entity982(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity982Repository : org.springframework.data.jpa.repository.JpaRepository<Entity982, Long> {
    fun findByField1(field1: String): List<Entity982>
    fun findByField3GreaterThan(value: Int): List<Entity982>
}

@Service
@Transactional
class Service982(private val repo: Entity982Repository) {
    fun findAll(): List<Entity982> = repo.findAll()
    fun findByName(name: String): List<Entity982> = repo.findByField1(name)
    fun save(entity: Entity982): Entity982 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity982>): List<Entity982> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
