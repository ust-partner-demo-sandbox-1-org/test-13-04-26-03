package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_512")
data class Entity512(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity512Repository : org.springframework.data.jpa.repository.JpaRepository<Entity512, Long> {
    fun findByField1(field1: String): List<Entity512>
    fun findByField3GreaterThan(value: Int): List<Entity512>
}

@Service
@Transactional
class Service512(private val repo: Entity512Repository) {
    fun findAll(): List<Entity512> = repo.findAll()
    fun findByName(name: String): List<Entity512> = repo.findByField1(name)
    fun save(entity: Entity512): Entity512 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity512>): List<Entity512> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
