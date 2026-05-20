package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_224")
data class Entity224(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity224Repository : org.springframework.data.jpa.repository.JpaRepository<Entity224, Long> {
    fun findByField1(field1: String): List<Entity224>
    fun findByField3GreaterThan(value: Int): List<Entity224>
}

@Service
@Transactional
class Service224(private val repo: Entity224Repository) {
    fun findAll(): List<Entity224> = repo.findAll()
    fun findByName(name: String): List<Entity224> = repo.findByField1(name)
    fun save(entity: Entity224): Entity224 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity224>): List<Entity224> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
