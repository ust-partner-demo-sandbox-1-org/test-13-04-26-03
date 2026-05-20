package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_998")
data class Entity998(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity998Repository : org.springframework.data.jpa.repository.JpaRepository<Entity998, Long> {
    fun findByField1(field1: String): List<Entity998>
    fun findByField3GreaterThan(value: Int): List<Entity998>
}

@Service
@Transactional
class Service998(private val repo: Entity998Repository) {
    fun findAll(): List<Entity998> = repo.findAll()
    fun findByName(name: String): List<Entity998> = repo.findByField1(name)
    fun save(entity: Entity998): Entity998 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity998>): List<Entity998> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
