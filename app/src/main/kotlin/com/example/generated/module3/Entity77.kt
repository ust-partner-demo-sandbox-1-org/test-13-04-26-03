package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_77")
data class Entity77(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity77Repository : org.springframework.data.jpa.repository.JpaRepository<Entity77, Long> {
    fun findByField1(field1: String): List<Entity77>
    fun findByField3GreaterThan(value: Int): List<Entity77>
}

@Service
@Transactional
class Service77(private val repo: Entity77Repository) {
    fun findAll(): List<Entity77> = repo.findAll()
    fun findByName(name: String): List<Entity77> = repo.findByField1(name)
    fun save(entity: Entity77): Entity77 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity77>): List<Entity77> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
