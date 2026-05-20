package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_642")
data class Entity642(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity642Repository : org.springframework.data.jpa.repository.JpaRepository<Entity642, Long> {
    fun findByField1(field1: String): List<Entity642>
    fun findByField3GreaterThan(value: Int): List<Entity642>
}

@Service
@Transactional
class Service642(private val repo: Entity642Repository) {
    fun findAll(): List<Entity642> = repo.findAll()
    fun findByName(name: String): List<Entity642> = repo.findByField1(name)
    fun save(entity: Entity642): Entity642 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity642>): List<Entity642> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
