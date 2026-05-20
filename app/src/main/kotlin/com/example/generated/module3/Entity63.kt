package com.example.generated.module3

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_63")
data class Entity63(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity63Repository : org.springframework.data.jpa.repository.JpaRepository<Entity63, Long> {
    fun findByField1(field1: String): List<Entity63>
    fun findByField3GreaterThan(value: Int): List<Entity63>
}

@Service
@Transactional
class Service63(private val repo: Entity63Repository) {
    fun findAll(): List<Entity63> = repo.findAll()
    fun findByName(name: String): List<Entity63> = repo.findByField1(name)
    fun save(entity: Entity63): Entity63 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity63>): List<Entity63> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
