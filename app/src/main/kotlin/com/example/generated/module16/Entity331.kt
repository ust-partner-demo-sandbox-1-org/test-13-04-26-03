package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_331")
data class Entity331(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity331Repository : org.springframework.data.jpa.repository.JpaRepository<Entity331, Long> {
    fun findByField1(field1: String): List<Entity331>
    fun findByField3GreaterThan(value: Int): List<Entity331>
}

@Service
@Transactional
class Service331(private val repo: Entity331Repository) {
    fun findAll(): List<Entity331> = repo.findAll()
    fun findByName(name: String): List<Entity331> = repo.findByField1(name)
    fun save(entity: Entity331): Entity331 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity331>): List<Entity331> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
