package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_554")
data class Entity554(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity554Repository : org.springframework.data.jpa.repository.JpaRepository<Entity554, Long> {
    fun findByField1(field1: String): List<Entity554>
    fun findByField3GreaterThan(value: Int): List<Entity554>
}

@Service
@Transactional
class Service554(private val repo: Entity554Repository) {
    fun findAll(): List<Entity554> = repo.findAll()
    fun findByName(name: String): List<Entity554> = repo.findByField1(name)
    fun save(entity: Entity554): Entity554 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity554>): List<Entity554> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
