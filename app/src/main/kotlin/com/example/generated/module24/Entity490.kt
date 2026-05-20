package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_490")
data class Entity490(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity490Repository : org.springframework.data.jpa.repository.JpaRepository<Entity490, Long> {
    fun findByField1(field1: String): List<Entity490>
    fun findByField3GreaterThan(value: Int): List<Entity490>
}

@Service
@Transactional
class Service490(private val repo: Entity490Repository) {
    fun findAll(): List<Entity490> = repo.findAll()
    fun findByName(name: String): List<Entity490> = repo.findByField1(name)
    fun save(entity: Entity490): Entity490 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity490>): List<Entity490> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
