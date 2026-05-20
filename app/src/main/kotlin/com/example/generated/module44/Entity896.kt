package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_896")
data class Entity896(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity896Repository : org.springframework.data.jpa.repository.JpaRepository<Entity896, Long> {
    fun findByField1(field1: String): List<Entity896>
    fun findByField3GreaterThan(value: Int): List<Entity896>
}

@Service
@Transactional
class Service896(private val repo: Entity896Repository) {
    fun findAll(): List<Entity896> = repo.findAll()
    fun findByName(name: String): List<Entity896> = repo.findByField1(name)
    fun save(entity: Entity896): Entity896 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity896>): List<Entity896> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
