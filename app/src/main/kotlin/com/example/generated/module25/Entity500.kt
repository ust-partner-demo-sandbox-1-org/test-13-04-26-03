package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_500")
data class Entity500(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity500Repository : org.springframework.data.jpa.repository.JpaRepository<Entity500, Long> {
    fun findByField1(field1: String): List<Entity500>
    fun findByField3GreaterThan(value: Int): List<Entity500>
}

@Service
@Transactional
class Service500(private val repo: Entity500Repository) {
    fun findAll(): List<Entity500> = repo.findAll()
    fun findByName(name: String): List<Entity500> = repo.findByField1(name)
    fun save(entity: Entity500): Entity500 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity500>): List<Entity500> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
