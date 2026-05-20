package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_255")
data class Entity255(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity255Repository : org.springframework.data.jpa.repository.JpaRepository<Entity255, Long> {
    fun findByField1(field1: String): List<Entity255>
    fun findByField3GreaterThan(value: Int): List<Entity255>
}

@Service
@Transactional
class Service255(private val repo: Entity255Repository) {
    fun findAll(): List<Entity255> = repo.findAll()
    fun findByName(name: String): List<Entity255> = repo.findByField1(name)
    fun save(entity: Entity255): Entity255 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity255>): List<Entity255> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
