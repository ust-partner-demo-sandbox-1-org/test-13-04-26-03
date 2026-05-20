package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_656")
data class Entity656(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity656Repository : org.springframework.data.jpa.repository.JpaRepository<Entity656, Long> {
    fun findByField1(field1: String): List<Entity656>
    fun findByField3GreaterThan(value: Int): List<Entity656>
}

@Service
@Transactional
class Service656(private val repo: Entity656Repository) {
    fun findAll(): List<Entity656> = repo.findAll()
    fun findByName(name: String): List<Entity656> = repo.findByField1(name)
    fun save(entity: Entity656): Entity656 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity656>): List<Entity656> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
