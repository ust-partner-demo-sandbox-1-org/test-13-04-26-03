package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_27")
data class Entity27(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity27Repository : org.springframework.data.jpa.repository.JpaRepository<Entity27, Long> {
    fun findByField1(field1: String): List<Entity27>
    fun findByField3GreaterThan(value: Int): List<Entity27>
}

@Service
@Transactional
class Service27(private val repo: Entity27Repository) {
    fun findAll(): List<Entity27> = repo.findAll()
    fun findByName(name: String): List<Entity27> = repo.findByField1(name)
    fun save(entity: Entity27): Entity27 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity27>): List<Entity27> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
