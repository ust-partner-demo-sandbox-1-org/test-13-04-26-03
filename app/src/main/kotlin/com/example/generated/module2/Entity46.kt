package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_46")
data class Entity46(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity46Repository : org.springframework.data.jpa.repository.JpaRepository<Entity46, Long> {
    fun findByField1(field1: String): List<Entity46>
    fun findByField3GreaterThan(value: Int): List<Entity46>
}

@Service
@Transactional
class Service46(private val repo: Entity46Repository) {
    fun findAll(): List<Entity46> = repo.findAll()
    fun findByName(name: String): List<Entity46> = repo.findByField1(name)
    fun save(entity: Entity46): Entity46 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity46>): List<Entity46> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
