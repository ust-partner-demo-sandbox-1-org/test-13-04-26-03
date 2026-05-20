package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_482")
data class Entity482(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity482Repository : org.springframework.data.jpa.repository.JpaRepository<Entity482, Long> {
    fun findByField1(field1: String): List<Entity482>
    fun findByField3GreaterThan(value: Int): List<Entity482>
}

@Service
@Transactional
class Service482(private val repo: Entity482Repository) {
    fun findAll(): List<Entity482> = repo.findAll()
    fun findByName(name: String): List<Entity482> = repo.findByField1(name)
    fun save(entity: Entity482): Entity482 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity482>): List<Entity482> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
