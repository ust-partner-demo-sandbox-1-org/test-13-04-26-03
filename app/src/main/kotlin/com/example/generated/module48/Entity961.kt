package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_961")
data class Entity961(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity961Repository : org.springframework.data.jpa.repository.JpaRepository<Entity961, Long> {
    fun findByField1(field1: String): List<Entity961>
    fun findByField3GreaterThan(value: Int): List<Entity961>
}

@Service
@Transactional
class Service961(private val repo: Entity961Repository) {
    fun findAll(): List<Entity961> = repo.findAll()
    fun findByName(name: String): List<Entity961> = repo.findByField1(name)
    fun save(entity: Entity961): Entity961 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity961>): List<Entity961> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
