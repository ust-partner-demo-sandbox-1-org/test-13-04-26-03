package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_794")
data class Entity794(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity794Repository : org.springframework.data.jpa.repository.JpaRepository<Entity794, Long> {
    fun findByField1(field1: String): List<Entity794>
    fun findByField3GreaterThan(value: Int): List<Entity794>
}

@Service
@Transactional
class Service794(private val repo: Entity794Repository) {
    fun findAll(): List<Entity794> = repo.findAll()
    fun findByName(name: String): List<Entity794> = repo.findByField1(name)
    fun save(entity: Entity794): Entity794 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity794>): List<Entity794> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
