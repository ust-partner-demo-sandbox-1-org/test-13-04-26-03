package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_11")
data class Entity11(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity11Repository : org.springframework.data.jpa.repository.JpaRepository<Entity11, Long> {
    fun findByField1(field1: String): List<Entity11>
    fun findByField3GreaterThan(value: Int): List<Entity11>
}

@Service
@Transactional
class Service11(private val repo: Entity11Repository) {
    fun findAll(): List<Entity11> = repo.findAll()
    fun findByName(name: String): List<Entity11> = repo.findByField1(name)
    fun save(entity: Entity11): Entity11 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity11>): List<Entity11> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
