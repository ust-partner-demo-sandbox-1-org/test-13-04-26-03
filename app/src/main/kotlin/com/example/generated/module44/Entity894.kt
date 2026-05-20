package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_894")
data class Entity894(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity894Repository : org.springframework.data.jpa.repository.JpaRepository<Entity894, Long> {
    fun findByField1(field1: String): List<Entity894>
    fun findByField3GreaterThan(value: Int): List<Entity894>
}

@Service
@Transactional
class Service894(private val repo: Entity894Repository) {
    fun findAll(): List<Entity894> = repo.findAll()
    fun findByName(name: String): List<Entity894> = repo.findByField1(name)
    fun save(entity: Entity894): Entity894 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity894>): List<Entity894> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
