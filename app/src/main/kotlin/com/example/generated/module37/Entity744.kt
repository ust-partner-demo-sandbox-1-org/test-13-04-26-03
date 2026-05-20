package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_744")
data class Entity744(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity744Repository : org.springframework.data.jpa.repository.JpaRepository<Entity744, Long> {
    fun findByField1(field1: String): List<Entity744>
    fun findByField3GreaterThan(value: Int): List<Entity744>
}

@Service
@Transactional
class Service744(private val repo: Entity744Repository) {
    fun findAll(): List<Entity744> = repo.findAll()
    fun findByName(name: String): List<Entity744> = repo.findByField1(name)
    fun save(entity: Entity744): Entity744 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity744>): List<Entity744> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
