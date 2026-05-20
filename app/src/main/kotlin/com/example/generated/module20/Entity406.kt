package com.example.generated.module20

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_406")
data class Entity406(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity406Repository : org.springframework.data.jpa.repository.JpaRepository<Entity406, Long> {
    fun findByField1(field1: String): List<Entity406>
    fun findByField3GreaterThan(value: Int): List<Entity406>
}

@Service
@Transactional
class Service406(private val repo: Entity406Repository) {
    fun findAll(): List<Entity406> = repo.findAll()
    fun findByName(name: String): List<Entity406> = repo.findByField1(name)
    fun save(entity: Entity406): Entity406 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity406>): List<Entity406> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
