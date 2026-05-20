package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_612")
data class Entity612(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity612Repository : org.springframework.data.jpa.repository.JpaRepository<Entity612, Long> {
    fun findByField1(field1: String): List<Entity612>
    fun findByField3GreaterThan(value: Int): List<Entity612>
}

@Service
@Transactional
class Service612(private val repo: Entity612Repository) {
    fun findAll(): List<Entity612> = repo.findAll()
    fun findByName(name: String): List<Entity612> = repo.findByField1(name)
    fun save(entity: Entity612): Entity612 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity612>): List<Entity612> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
