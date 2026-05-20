package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_450")
data class Entity450(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity450Repository : org.springframework.data.jpa.repository.JpaRepository<Entity450, Long> {
    fun findByField1(field1: String): List<Entity450>
    fun findByField3GreaterThan(value: Int): List<Entity450>
}

@Service
@Transactional
class Service450(private val repo: Entity450Repository) {
    fun findAll(): List<Entity450> = repo.findAll()
    fun findByName(name: String): List<Entity450> = repo.findByField1(name)
    fun save(entity: Entity450): Entity450 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity450>): List<Entity450> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
