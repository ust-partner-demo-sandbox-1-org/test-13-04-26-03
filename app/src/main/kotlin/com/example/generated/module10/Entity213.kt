package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_213")
data class Entity213(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity213Repository : org.springframework.data.jpa.repository.JpaRepository<Entity213, Long> {
    fun findByField1(field1: String): List<Entity213>
    fun findByField3GreaterThan(value: Int): List<Entity213>
}

@Service
@Transactional
class Service213(private val repo: Entity213Repository) {
    fun findAll(): List<Entity213> = repo.findAll()
    fun findByName(name: String): List<Entity213> = repo.findByField1(name)
    fun save(entity: Entity213): Entity213 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity213>): List<Entity213> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
