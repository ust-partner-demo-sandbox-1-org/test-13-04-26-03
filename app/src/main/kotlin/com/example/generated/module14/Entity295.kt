package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_295")
data class Entity295(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity295Repository : org.springframework.data.jpa.repository.JpaRepository<Entity295, Long> {
    fun findByField1(field1: String): List<Entity295>
    fun findByField3GreaterThan(value: Int): List<Entity295>
}

@Service
@Transactional
class Service295(private val repo: Entity295Repository) {
    fun findAll(): List<Entity295> = repo.findAll()
    fun findByName(name: String): List<Entity295> = repo.findByField1(name)
    fun save(entity: Entity295): Entity295 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity295>): List<Entity295> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
