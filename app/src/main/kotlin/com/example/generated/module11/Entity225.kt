package com.example.generated.module11

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_225")
data class Entity225(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity225Repository : org.springframework.data.jpa.repository.JpaRepository<Entity225, Long> {
    fun findByField1(field1: String): List<Entity225>
    fun findByField3GreaterThan(value: Int): List<Entity225>
}

@Service
@Transactional
class Service225(private val repo: Entity225Repository) {
    fun findAll(): List<Entity225> = repo.findAll()
    fun findByName(name: String): List<Entity225> = repo.findByField1(name)
    fun save(entity: Entity225): Entity225 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity225>): List<Entity225> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
