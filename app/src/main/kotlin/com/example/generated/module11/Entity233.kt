package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_233")
data class Entity233(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity233Repository : org.springframework.data.jpa.repository.JpaRepository<Entity233, Long> {
    fun findByField1(field1: String): List<Entity233>
    fun findByField3GreaterThan(value: Int): List<Entity233>
}

@Service
@Transactional
class Service233(private val repo: Entity233Repository) {
    fun findAll(): List<Entity233> = repo.findAll()
    fun findByName(name: String): List<Entity233> = repo.findByField1(name)
    fun save(entity: Entity233): Entity233 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity233>): List<Entity233> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
