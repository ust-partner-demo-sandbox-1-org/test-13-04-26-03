package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_409")
data class Entity409(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity409Repository : org.springframework.data.jpa.repository.JpaRepository<Entity409, Long> {
    fun findByField1(field1: String): List<Entity409>
    fun findByField3GreaterThan(value: Int): List<Entity409>
}

@Service
@Transactional
class Service409(private val repo: Entity409Repository) {
    fun findAll(): List<Entity409> = repo.findAll()
    fun findByName(name: String): List<Entity409> = repo.findByField1(name)
    fun save(entity: Entity409): Entity409 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity409>): List<Entity409> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
