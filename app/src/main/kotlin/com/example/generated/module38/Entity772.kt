package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_772")
data class Entity772(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity772Repository : org.springframework.data.jpa.repository.JpaRepository<Entity772, Long> {
    fun findByField1(field1: String): List<Entity772>
    fun findByField3GreaterThan(value: Int): List<Entity772>
}

@Service
@Transactional
class Service772(private val repo: Entity772Repository) {
    fun findAll(): List<Entity772> = repo.findAll()
    fun findByName(name: String): List<Entity772> = repo.findByField1(name)
    fun save(entity: Entity772): Entity772 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity772>): List<Entity772> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
