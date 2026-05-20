package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_730")
data class Entity730(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity730Repository : org.springframework.data.jpa.repository.JpaRepository<Entity730, Long> {
    fun findByField1(field1: String): List<Entity730>
    fun findByField3GreaterThan(value: Int): List<Entity730>
}

@Service
@Transactional
class Service730(private val repo: Entity730Repository) {
    fun findAll(): List<Entity730> = repo.findAll()
    fun findByName(name: String): List<Entity730> = repo.findByField1(name)
    fun save(entity: Entity730): Entity730 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity730>): List<Entity730> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
