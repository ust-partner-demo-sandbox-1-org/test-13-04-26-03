package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_308")
data class Entity308(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity308Repository : org.springframework.data.jpa.repository.JpaRepository<Entity308, Long> {
    fun findByField1(field1: String): List<Entity308>
    fun findByField3GreaterThan(value: Int): List<Entity308>
}

@Service
@Transactional
class Service308(private val repo: Entity308Repository) {
    fun findAll(): List<Entity308> = repo.findAll()
    fun findByName(name: String): List<Entity308> = repo.findByField1(name)
    fun save(entity: Entity308): Entity308 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity308>): List<Entity308> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
