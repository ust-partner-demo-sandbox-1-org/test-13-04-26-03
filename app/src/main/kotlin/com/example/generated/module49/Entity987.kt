package com.example.generated.module49

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_987")
data class Entity987(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity987Repository : org.springframework.data.jpa.repository.JpaRepository<Entity987, Long> {
    fun findByField1(field1: String): List<Entity987>
    fun findByField3GreaterThan(value: Int): List<Entity987>
}

@Service
@Transactional
class Service987(private val repo: Entity987Repository) {
    fun findAll(): List<Entity987> = repo.findAll()
    fun findByName(name: String): List<Entity987> = repo.findByField1(name)
    fun save(entity: Entity987): Entity987 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity987>): List<Entity987> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
