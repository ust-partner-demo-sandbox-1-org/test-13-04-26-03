package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_592")
data class Entity592(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity592Repository : org.springframework.data.jpa.repository.JpaRepository<Entity592, Long> {
    fun findByField1(field1: String): List<Entity592>
    fun findByField3GreaterThan(value: Int): List<Entity592>
}

@Service
@Transactional
class Service592(private val repo: Entity592Repository) {
    fun findAll(): List<Entity592> = repo.findAll()
    fun findByName(name: String): List<Entity592> = repo.findByField1(name)
    fun save(entity: Entity592): Entity592 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity592>): List<Entity592> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
