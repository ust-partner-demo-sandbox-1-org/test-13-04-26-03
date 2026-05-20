package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_739")
data class Entity739(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity739Repository : org.springframework.data.jpa.repository.JpaRepository<Entity739, Long> {
    fun findByField1(field1: String): List<Entity739>
    fun findByField3GreaterThan(value: Int): List<Entity739>
}

@Service
@Transactional
class Service739(private val repo: Entity739Repository) {
    fun findAll(): List<Entity739> = repo.findAll()
    fun findByName(name: String): List<Entity739> = repo.findByField1(name)
    fun save(entity: Entity739): Entity739 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity739>): List<Entity739> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
