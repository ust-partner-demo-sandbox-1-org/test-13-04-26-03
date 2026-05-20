package com.example.generated.module19

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_386")
data class Entity386(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity386Repository : org.springframework.data.jpa.repository.JpaRepository<Entity386, Long> {
    fun findByField1(field1: String): List<Entity386>
    fun findByField3GreaterThan(value: Int): List<Entity386>
}

@Service
@Transactional
class Service386(private val repo: Entity386Repository) {
    fun findAll(): List<Entity386> = repo.findAll()
    fun findByName(name: String): List<Entity386> = repo.findByField1(name)
    fun save(entity: Entity386): Entity386 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity386>): List<Entity386> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
