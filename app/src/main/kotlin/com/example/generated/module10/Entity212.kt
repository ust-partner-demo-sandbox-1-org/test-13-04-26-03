package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_212")
data class Entity212(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity212Repository : org.springframework.data.jpa.repository.JpaRepository<Entity212, Long> {
    fun findByField1(field1: String): List<Entity212>
    fun findByField3GreaterThan(value: Int): List<Entity212>
}

@Service
@Transactional
class Service212(private val repo: Entity212Repository) {
    fun findAll(): List<Entity212> = repo.findAll()
    fun findByName(name: String): List<Entity212> = repo.findByField1(name)
    fun save(entity: Entity212): Entity212 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity212>): List<Entity212> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
