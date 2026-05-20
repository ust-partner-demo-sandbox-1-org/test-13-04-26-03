package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_502")
data class Entity502(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity502Repository : org.springframework.data.jpa.repository.JpaRepository<Entity502, Long> {
    fun findByField1(field1: String): List<Entity502>
    fun findByField3GreaterThan(value: Int): List<Entity502>
}

@Service
@Transactional
class Service502(private val repo: Entity502Repository) {
    fun findAll(): List<Entity502> = repo.findAll()
    fun findByName(name: String): List<Entity502> = repo.findByField1(name)
    fun save(entity: Entity502): Entity502 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity502>): List<Entity502> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
