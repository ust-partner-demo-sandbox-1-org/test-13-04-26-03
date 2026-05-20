package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_689")
data class Entity689(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity689Repository : org.springframework.data.jpa.repository.JpaRepository<Entity689, Long> {
    fun findByField1(field1: String): List<Entity689>
    fun findByField3GreaterThan(value: Int): List<Entity689>
}

@Service
@Transactional
class Service689(private val repo: Entity689Repository) {
    fun findAll(): List<Entity689> = repo.findAll()
    fun findByName(name: String): List<Entity689> = repo.findByField1(name)
    fun save(entity: Entity689): Entity689 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity689>): List<Entity689> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
