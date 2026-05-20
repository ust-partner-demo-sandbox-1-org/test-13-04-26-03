package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_506")
data class Entity506(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity506Repository : org.springframework.data.jpa.repository.JpaRepository<Entity506, Long> {
    fun findByField1(field1: String): List<Entity506>
    fun findByField3GreaterThan(value: Int): List<Entity506>
}

@Service
@Transactional
class Service506(private val repo: Entity506Repository) {
    fun findAll(): List<Entity506> = repo.findAll()
    fun findByName(name: String): List<Entity506> = repo.findByField1(name)
    fun save(entity: Entity506): Entity506 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity506>): List<Entity506> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
