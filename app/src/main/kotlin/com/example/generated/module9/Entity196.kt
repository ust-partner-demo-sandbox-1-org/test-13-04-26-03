package com.example.generated.module9

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_196")
data class Entity196(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity196Repository : org.springframework.data.jpa.repository.JpaRepository<Entity196, Long> {
    fun findByField1(field1: String): List<Entity196>
    fun findByField3GreaterThan(value: Int): List<Entity196>
}

@Service
@Transactional
class Service196(private val repo: Entity196Repository) {
    fun findAll(): List<Entity196> = repo.findAll()
    fun findByName(name: String): List<Entity196> = repo.findByField1(name)
    fun save(entity: Entity196): Entity196 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity196>): List<Entity196> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
