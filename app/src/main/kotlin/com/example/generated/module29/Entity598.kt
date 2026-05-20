package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_598")
data class Entity598(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity598Repository : org.springframework.data.jpa.repository.JpaRepository<Entity598, Long> {
    fun findByField1(field1: String): List<Entity598>
    fun findByField3GreaterThan(value: Int): List<Entity598>
}

@Service
@Transactional
class Service598(private val repo: Entity598Repository) {
    fun findAll(): List<Entity598> = repo.findAll()
    fun findByName(name: String): List<Entity598> = repo.findByField1(name)
    fun save(entity: Entity598): Entity598 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity598>): List<Entity598> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
