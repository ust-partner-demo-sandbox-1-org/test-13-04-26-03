package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_976")
data class Entity976(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity976Repository : org.springframework.data.jpa.repository.JpaRepository<Entity976, Long> {
    fun findByField1(field1: String): List<Entity976>
    fun findByField3GreaterThan(value: Int): List<Entity976>
}

@Service
@Transactional
class Service976(private val repo: Entity976Repository) {
    fun findAll(): List<Entity976> = repo.findAll()
    fun findByName(name: String): List<Entity976> = repo.findByField1(name)
    fun save(entity: Entity976): Entity976 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity976>): List<Entity976> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
