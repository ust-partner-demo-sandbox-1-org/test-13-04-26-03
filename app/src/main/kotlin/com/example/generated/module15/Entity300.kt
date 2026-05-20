package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_300")
data class Entity300(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity300Repository : org.springframework.data.jpa.repository.JpaRepository<Entity300, Long> {
    fun findByField1(field1: String): List<Entity300>
    fun findByField3GreaterThan(value: Int): List<Entity300>
}

@Service
@Transactional
class Service300(private val repo: Entity300Repository) {
    fun findAll(): List<Entity300> = repo.findAll()
    fun findByName(name: String): List<Entity300> = repo.findByField1(name)
    fun save(entity: Entity300): Entity300 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity300>): List<Entity300> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
