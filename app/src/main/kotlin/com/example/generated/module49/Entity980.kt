package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_980")
data class Entity980(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity980Repository : org.springframework.data.jpa.repository.JpaRepository<Entity980, Long> {
    fun findByField1(field1: String): List<Entity980>
    fun findByField3GreaterThan(value: Int): List<Entity980>
}

@Service
@Transactional
class Service980(private val repo: Entity980Repository) {
    fun findAll(): List<Entity980> = repo.findAll()
    fun findByName(name: String): List<Entity980> = repo.findByField1(name)
    fun save(entity: Entity980): Entity980 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity980>): List<Entity980> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
