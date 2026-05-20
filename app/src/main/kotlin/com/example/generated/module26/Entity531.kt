package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_531")
data class Entity531(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity531Repository : org.springframework.data.jpa.repository.JpaRepository<Entity531, Long> {
    fun findByField1(field1: String): List<Entity531>
    fun findByField3GreaterThan(value: Int): List<Entity531>
}

@Service
@Transactional
class Service531(private val repo: Entity531Repository) {
    fun findAll(): List<Entity531> = repo.findAll()
    fun findByName(name: String): List<Entity531> = repo.findByField1(name)
    fun save(entity: Entity531): Entity531 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity531>): List<Entity531> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
