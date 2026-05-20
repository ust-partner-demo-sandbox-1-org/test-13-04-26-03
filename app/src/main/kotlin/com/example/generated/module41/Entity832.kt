package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_832")
data class Entity832(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity832Repository : org.springframework.data.jpa.repository.JpaRepository<Entity832, Long> {
    fun findByField1(field1: String): List<Entity832>
    fun findByField3GreaterThan(value: Int): List<Entity832>
}

@Service
@Transactional
class Service832(private val repo: Entity832Repository) {
    fun findAll(): List<Entity832> = repo.findAll()
    fun findByName(name: String): List<Entity832> = repo.findByField1(name)
    fun save(entity: Entity832): Entity832 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity832>): List<Entity832> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
