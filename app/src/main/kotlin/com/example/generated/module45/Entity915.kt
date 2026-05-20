package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_915")
data class Entity915(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity915Repository : org.springframework.data.jpa.repository.JpaRepository<Entity915, Long> {
    fun findByField1(field1: String): List<Entity915>
    fun findByField3GreaterThan(value: Int): List<Entity915>
}

@Service
@Transactional
class Service915(private val repo: Entity915Repository) {
    fun findAll(): List<Entity915> = repo.findAll()
    fun findByName(name: String): List<Entity915> = repo.findByField1(name)
    fun save(entity: Entity915): Entity915 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity915>): List<Entity915> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
