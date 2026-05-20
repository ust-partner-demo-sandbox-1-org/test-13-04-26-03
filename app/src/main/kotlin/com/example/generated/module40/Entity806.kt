package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_806")
data class Entity806(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity806Repository : org.springframework.data.jpa.repository.JpaRepository<Entity806, Long> {
    fun findByField1(field1: String): List<Entity806>
    fun findByField3GreaterThan(value: Int): List<Entity806>
}

@Service
@Transactional
class Service806(private val repo: Entity806Repository) {
    fun findAll(): List<Entity806> = repo.findAll()
    fun findByName(name: String): List<Entity806> = repo.findByField1(name)
    fun save(entity: Entity806): Entity806 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity806>): List<Entity806> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
