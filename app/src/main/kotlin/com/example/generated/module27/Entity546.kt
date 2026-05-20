package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_546")
data class Entity546(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity546Repository : org.springframework.data.jpa.repository.JpaRepository<Entity546, Long> {
    fun findByField1(field1: String): List<Entity546>
    fun findByField3GreaterThan(value: Int): List<Entity546>
}

@Service
@Transactional
class Service546(private val repo: Entity546Repository) {
    fun findAll(): List<Entity546> = repo.findAll()
    fun findByName(name: String): List<Entity546> = repo.findByField1(name)
    fun save(entity: Entity546): Entity546 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity546>): List<Entity546> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
