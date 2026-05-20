package com.example.generated.module21

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_423")
data class Entity423(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity423Repository : org.springframework.data.jpa.repository.JpaRepository<Entity423, Long> {
    fun findByField1(field1: String): List<Entity423>
    fun findByField3GreaterThan(value: Int): List<Entity423>
}

@Service
@Transactional
class Service423(private val repo: Entity423Repository) {
    fun findAll(): List<Entity423> = repo.findAll()
    fun findByName(name: String): List<Entity423> = repo.findByField1(name)
    fun save(entity: Entity423): Entity423 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity423>): List<Entity423> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
