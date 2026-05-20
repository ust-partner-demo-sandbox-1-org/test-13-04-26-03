package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_72")
data class Entity72(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity72Repository : org.springframework.data.jpa.repository.JpaRepository<Entity72, Long> {
    fun findByField1(field1: String): List<Entity72>
    fun findByField3GreaterThan(value: Int): List<Entity72>
}

@Service
@Transactional
class Service72(private val repo: Entity72Repository) {
    fun findAll(): List<Entity72> = repo.findAll()
    fun findByName(name: String): List<Entity72> = repo.findByField1(name)
    fun save(entity: Entity72): Entity72 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity72>): List<Entity72> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
