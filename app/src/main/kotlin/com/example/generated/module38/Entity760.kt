package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_760")
data class Entity760(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity760Repository : org.springframework.data.jpa.repository.JpaRepository<Entity760, Long> {
    fun findByField1(field1: String): List<Entity760>
    fun findByField3GreaterThan(value: Int): List<Entity760>
}

@Service
@Transactional
class Service760(private val repo: Entity760Repository) {
    fun findAll(): List<Entity760> = repo.findAll()
    fun findByName(name: String): List<Entity760> = repo.findByField1(name)
    fun save(entity: Entity760): Entity760 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity760>): List<Entity760> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
