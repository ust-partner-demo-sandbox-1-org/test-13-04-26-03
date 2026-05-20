package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_252")
data class Entity252(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity252Repository : org.springframework.data.jpa.repository.JpaRepository<Entity252, Long> {
    fun findByField1(field1: String): List<Entity252>
    fun findByField3GreaterThan(value: Int): List<Entity252>
}

@Service
@Transactional
class Service252(private val repo: Entity252Repository) {
    fun findAll(): List<Entity252> = repo.findAll()
    fun findByName(name: String): List<Entity252> = repo.findByField1(name)
    fun save(entity: Entity252): Entity252 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity252>): List<Entity252> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
