package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_361")
data class Entity361(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity361Repository : org.springframework.data.jpa.repository.JpaRepository<Entity361, Long> {
    fun findByField1(field1: String): List<Entity361>
    fun findByField3GreaterThan(value: Int): List<Entity361>
}

@Service
@Transactional
class Service361(private val repo: Entity361Repository) {
    fun findAll(): List<Entity361> = repo.findAll()
    fun findByName(name: String): List<Entity361> = repo.findByField1(name)
    fun save(entity: Entity361): Entity361 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity361>): List<Entity361> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
