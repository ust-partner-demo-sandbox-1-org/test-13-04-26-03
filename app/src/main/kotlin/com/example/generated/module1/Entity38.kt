package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_38")
data class Entity38(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity38Repository : org.springframework.data.jpa.repository.JpaRepository<Entity38, Long> {
    fun findByField1(field1: String): List<Entity38>
    fun findByField3GreaterThan(value: Int): List<Entity38>
}

@Service
@Transactional
class Service38(private val repo: Entity38Repository) {
    fun findAll(): List<Entity38> = repo.findAll()
    fun findByName(name: String): List<Entity38> = repo.findByField1(name)
    fun save(entity: Entity38): Entity38 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity38>): List<Entity38> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
