package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_661")
data class Entity661(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity661Repository : org.springframework.data.jpa.repository.JpaRepository<Entity661, Long> {
    fun findByField1(field1: String): List<Entity661>
    fun findByField3GreaterThan(value: Int): List<Entity661>
}

@Service
@Transactional
class Service661(private val repo: Entity661Repository) {
    fun findAll(): List<Entity661> = repo.findAll()
    fun findByName(name: String): List<Entity661> = repo.findByField1(name)
    fun save(entity: Entity661): Entity661 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity661>): List<Entity661> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
