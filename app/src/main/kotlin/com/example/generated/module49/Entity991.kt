package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_991")
data class Entity991(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity991Repository : org.springframework.data.jpa.repository.JpaRepository<Entity991, Long> {
    fun findByField1(field1: String): List<Entity991>
    fun findByField3GreaterThan(value: Int): List<Entity991>
}

@Service
@Transactional
class Service991(private val repo: Entity991Repository) {
    fun findAll(): List<Entity991> = repo.findAll()
    fun findByName(name: String): List<Entity991> = repo.findByField1(name)
    fun save(entity: Entity991): Entity991 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity991>): List<Entity991> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
