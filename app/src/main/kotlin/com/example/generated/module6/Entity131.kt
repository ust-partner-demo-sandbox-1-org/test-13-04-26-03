package com.example.generated.module6

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_131")
data class Entity131(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity131Repository : org.springframework.data.jpa.repository.JpaRepository<Entity131, Long> {
    fun findByField1(field1: String): List<Entity131>
    fun findByField3GreaterThan(value: Int): List<Entity131>
}

@Service
@Transactional
class Service131(private val repo: Entity131Repository) {
    fun findAll(): List<Entity131> = repo.findAll()
    fun findByName(name: String): List<Entity131> = repo.findByField1(name)
    fun save(entity: Entity131): Entity131 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity131>): List<Entity131> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
