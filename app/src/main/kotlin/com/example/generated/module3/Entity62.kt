package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_62")
data class Entity62(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity62Repository : org.springframework.data.jpa.repository.JpaRepository<Entity62, Long> {
    fun findByField1(field1: String): List<Entity62>
    fun findByField3GreaterThan(value: Int): List<Entity62>
}

@Service
@Transactional
class Service62(private val repo: Entity62Repository) {
    fun findAll(): List<Entity62> = repo.findAll()
    fun findByName(name: String): List<Entity62> = repo.findByField1(name)
    fun save(entity: Entity62): Entity62 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity62>): List<Entity62> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
