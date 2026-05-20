package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_652")
data class Entity652(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity652Repository : org.springframework.data.jpa.repository.JpaRepository<Entity652, Long> {
    fun findByField1(field1: String): List<Entity652>
    fun findByField3GreaterThan(value: Int): List<Entity652>
}

@Service
@Transactional
class Service652(private val repo: Entity652Repository) {
    fun findAll(): List<Entity652> = repo.findAll()
    fun findByName(name: String): List<Entity652> = repo.findByField1(name)
    fun save(entity: Entity652): Entity652 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity652>): List<Entity652> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
