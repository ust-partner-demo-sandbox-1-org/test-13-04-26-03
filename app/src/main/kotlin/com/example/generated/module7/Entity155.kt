package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_155")
data class Entity155(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity155Repository : org.springframework.data.jpa.repository.JpaRepository<Entity155, Long> {
    fun findByField1(field1: String): List<Entity155>
    fun findByField3GreaterThan(value: Int): List<Entity155>
}

@Service
@Transactional
class Service155(private val repo: Entity155Repository) {
    fun findAll(): List<Entity155> = repo.findAll()
    fun findByName(name: String): List<Entity155> = repo.findByField1(name)
    fun save(entity: Entity155): Entity155 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity155>): List<Entity155> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
