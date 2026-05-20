package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_840")
data class Entity840(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity840Repository : org.springframework.data.jpa.repository.JpaRepository<Entity840, Long> {
    fun findByField1(field1: String): List<Entity840>
    fun findByField3GreaterThan(value: Int): List<Entity840>
}

@Service
@Transactional
class Service840(private val repo: Entity840Repository) {
    fun findAll(): List<Entity840> = repo.findAll()
    fun findByName(name: String): List<Entity840> = repo.findByField1(name)
    fun save(entity: Entity840): Entity840 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity840>): List<Entity840> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
