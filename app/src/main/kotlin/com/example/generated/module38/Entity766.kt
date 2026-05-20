package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_766")
data class Entity766(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity766Repository : org.springframework.data.jpa.repository.JpaRepository<Entity766, Long> {
    fun findByField1(field1: String): List<Entity766>
    fun findByField3GreaterThan(value: Int): List<Entity766>
}

@Service
@Transactional
class Service766(private val repo: Entity766Repository) {
    fun findAll(): List<Entity766> = repo.findAll()
    fun findByName(name: String): List<Entity766> = repo.findByField1(name)
    fun save(entity: Entity766): Entity766 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity766>): List<Entity766> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
