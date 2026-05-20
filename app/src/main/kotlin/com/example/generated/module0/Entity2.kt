package com.example.generated.module0

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_2")
data class Entity2(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity2Repository : org.springframework.data.jpa.repository.JpaRepository<Entity2, Long> {
    fun findByField1(field1: String): List<Entity2>
    fun findByField3GreaterThan(value: Int): List<Entity2>
}

@Service
@Transactional
class Service2(private val repo: Entity2Repository) {
    fun findAll(): List<Entity2> = repo.findAll()
    fun findByName(name: String): List<Entity2> = repo.findByField1(name)
    fun save(entity: Entity2): Entity2 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity2>): List<Entity2> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
