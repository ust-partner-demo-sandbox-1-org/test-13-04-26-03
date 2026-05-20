package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_620")
data class Entity620(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity620Repository : org.springframework.data.jpa.repository.JpaRepository<Entity620, Long> {
    fun findByField1(field1: String): List<Entity620>
    fun findByField3GreaterThan(value: Int): List<Entity620>
}

@Service
@Transactional
class Service620(private val repo: Entity620Repository) {
    fun findAll(): List<Entity620> = repo.findAll()
    fun findByName(name: String): List<Entity620> = repo.findByField1(name)
    fun save(entity: Entity620): Entity620 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity620>): List<Entity620> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
