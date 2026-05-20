package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_781")
data class Entity781(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity781Repository : org.springframework.data.jpa.repository.JpaRepository<Entity781, Long> {
    fun findByField1(field1: String): List<Entity781>
    fun findByField3GreaterThan(value: Int): List<Entity781>
}

@Service
@Transactional
class Service781(private val repo: Entity781Repository) {
    fun findAll(): List<Entity781> = repo.findAll()
    fun findByName(name: String): List<Entity781> = repo.findByField1(name)
    fun save(entity: Entity781): Entity781 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity781>): List<Entity781> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
