package com.example.generated.module29

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_591")
data class Entity591(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity591Repository : org.springframework.data.jpa.repository.JpaRepository<Entity591, Long> {
    fun findByField1(field1: String): List<Entity591>
    fun findByField3GreaterThan(value: Int): List<Entity591>
}

@Service
@Transactional
class Service591(private val repo: Entity591Repository) {
    fun findAll(): List<Entity591> = repo.findAll()
    fun findByName(name: String): List<Entity591> = repo.findByField1(name)
    fun save(entity: Entity591): Entity591 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity591>): List<Entity591> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
