package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_445")
data class Entity445(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity445Repository : org.springframework.data.jpa.repository.JpaRepository<Entity445, Long> {
    fun findByField1(field1: String): List<Entity445>
    fun findByField3GreaterThan(value: Int): List<Entity445>
}

@Service
@Transactional
class Service445(private val repo: Entity445Repository) {
    fun findAll(): List<Entity445> = repo.findAll()
    fun findByName(name: String): List<Entity445> = repo.findByField1(name)
    fun save(entity: Entity445): Entity445 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity445>): List<Entity445> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
