package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_889")
data class Entity889(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity889Repository : org.springframework.data.jpa.repository.JpaRepository<Entity889, Long> {
    fun findByField1(field1: String): List<Entity889>
    fun findByField3GreaterThan(value: Int): List<Entity889>
}

@Service
@Transactional
class Service889(private val repo: Entity889Repository) {
    fun findAll(): List<Entity889> = repo.findAll()
    fun findByName(name: String): List<Entity889> = repo.findByField1(name)
    fun save(entity: Entity889): Entity889 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity889>): List<Entity889> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
