package com.example.generated.module25

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_510")
data class Entity510(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity510Repository : org.springframework.data.jpa.repository.JpaRepository<Entity510, Long> {
    fun findByField1(field1: String): List<Entity510>
    fun findByField3GreaterThan(value: Int): List<Entity510>
}

@Service
@Transactional
class Service510(private val repo: Entity510Repository) {
    fun findAll(): List<Entity510> = repo.findAll()
    fun findByName(name: String): List<Entity510> = repo.findByField1(name)
    fun save(entity: Entity510): Entity510 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity510>): List<Entity510> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
