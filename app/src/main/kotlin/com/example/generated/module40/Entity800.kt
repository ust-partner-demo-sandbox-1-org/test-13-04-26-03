package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_800")
data class Entity800(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity800Repository : org.springframework.data.jpa.repository.JpaRepository<Entity800, Long> {
    fun findByField1(field1: String): List<Entity800>
    fun findByField3GreaterThan(value: Int): List<Entity800>
}

@Service
@Transactional
class Service800(private val repo: Entity800Repository) {
    fun findAll(): List<Entity800> = repo.findAll()
    fun findByName(name: String): List<Entity800> = repo.findByField1(name)
    fun save(entity: Entity800): Entity800 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity800>): List<Entity800> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
