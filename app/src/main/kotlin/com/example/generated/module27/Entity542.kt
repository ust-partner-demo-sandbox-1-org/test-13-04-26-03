package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_542")
data class Entity542(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity542Repository : org.springframework.data.jpa.repository.JpaRepository<Entity542, Long> {
    fun findByField1(field1: String): List<Entity542>
    fun findByField3GreaterThan(value: Int): List<Entity542>
}

@Service
@Transactional
class Service542(private val repo: Entity542Repository) {
    fun findAll(): List<Entity542> = repo.findAll()
    fun findByName(name: String): List<Entity542> = repo.findByField1(name)
    fun save(entity: Entity542): Entity542 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity542>): List<Entity542> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
