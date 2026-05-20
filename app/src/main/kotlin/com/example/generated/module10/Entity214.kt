package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_214")
data class Entity214(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity214Repository : org.springframework.data.jpa.repository.JpaRepository<Entity214, Long> {
    fun findByField1(field1: String): List<Entity214>
    fun findByField3GreaterThan(value: Int): List<Entity214>
}

@Service
@Transactional
class Service214(private val repo: Entity214Repository) {
    fun findAll(): List<Entity214> = repo.findAll()
    fun findByName(name: String): List<Entity214> = repo.findByField1(name)
    fun save(entity: Entity214): Entity214 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity214>): List<Entity214> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
