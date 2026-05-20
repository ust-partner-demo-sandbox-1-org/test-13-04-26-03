package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_815")
data class Entity815(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity815Repository : org.springframework.data.jpa.repository.JpaRepository<Entity815, Long> {
    fun findByField1(field1: String): List<Entity815>
    fun findByField3GreaterThan(value: Int): List<Entity815>
}

@Service
@Transactional
class Service815(private val repo: Entity815Repository) {
    fun findAll(): List<Entity815> = repo.findAll()
    fun findByName(name: String): List<Entity815> = repo.findByField1(name)
    fun save(entity: Entity815): Entity815 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity815>): List<Entity815> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
