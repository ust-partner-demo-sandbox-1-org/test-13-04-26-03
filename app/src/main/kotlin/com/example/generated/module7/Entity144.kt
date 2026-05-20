package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_144")
data class Entity144(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity144Repository : org.springframework.data.jpa.repository.JpaRepository<Entity144, Long> {
    fun findByField1(field1: String): List<Entity144>
    fun findByField3GreaterThan(value: Int): List<Entity144>
}

@Service
@Transactional
class Service144(private val repo: Entity144Repository) {
    fun findAll(): List<Entity144> = repo.findAll()
    fun findByName(name: String): List<Entity144> = repo.findByField1(name)
    fun save(entity: Entity144): Entity144 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity144>): List<Entity144> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
