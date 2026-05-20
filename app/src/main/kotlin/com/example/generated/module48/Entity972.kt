package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_972")
data class Entity972(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity972Repository : org.springframework.data.jpa.repository.JpaRepository<Entity972, Long> {
    fun findByField1(field1: String): List<Entity972>
    fun findByField3GreaterThan(value: Int): List<Entity972>
}

@Service
@Transactional
class Service972(private val repo: Entity972Repository) {
    fun findAll(): List<Entity972> = repo.findAll()
    fun findByName(name: String): List<Entity972> = repo.findByField1(name)
    fun save(entity: Entity972): Entity972 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity972>): List<Entity972> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
