package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_950")
data class Entity950(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity950Repository : org.springframework.data.jpa.repository.JpaRepository<Entity950, Long> {
    fun findByField1(field1: String): List<Entity950>
    fun findByField3GreaterThan(value: Int): List<Entity950>
}

@Service
@Transactional
class Service950(private val repo: Entity950Repository) {
    fun findAll(): List<Entity950> = repo.findAll()
    fun findByName(name: String): List<Entity950> = repo.findByField1(name)
    fun save(entity: Entity950): Entity950 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity950>): List<Entity950> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
