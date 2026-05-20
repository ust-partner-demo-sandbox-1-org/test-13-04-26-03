package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_963")
data class Entity963(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity963Repository : org.springframework.data.jpa.repository.JpaRepository<Entity963, Long> {
    fun findByField1(field1: String): List<Entity963>
    fun findByField3GreaterThan(value: Int): List<Entity963>
}

@Service
@Transactional
class Service963(private val repo: Entity963Repository) {
    fun findAll(): List<Entity963> = repo.findAll()
    fun findByName(name: String): List<Entity963> = repo.findByField1(name)
    fun save(entity: Entity963): Entity963 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity963>): List<Entity963> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
