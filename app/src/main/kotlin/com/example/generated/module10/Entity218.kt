package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_218")
data class Entity218(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity218Repository : org.springframework.data.jpa.repository.JpaRepository<Entity218, Long> {
    fun findByField1(field1: String): List<Entity218>
    fun findByField3GreaterThan(value: Int): List<Entity218>
}

@Service
@Transactional
class Service218(private val repo: Entity218Repository) {
    fun findAll(): List<Entity218> = repo.findAll()
    fun findByName(name: String): List<Entity218> = repo.findByField1(name)
    fun save(entity: Entity218): Entity218 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity218>): List<Entity218> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
