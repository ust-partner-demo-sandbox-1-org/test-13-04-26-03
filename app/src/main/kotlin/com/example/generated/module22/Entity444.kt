package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_444")
data class Entity444(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity444Repository : org.springframework.data.jpa.repository.JpaRepository<Entity444, Long> {
    fun findByField1(field1: String): List<Entity444>
    fun findByField3GreaterThan(value: Int): List<Entity444>
}

@Service
@Transactional
class Service444(private val repo: Entity444Repository) {
    fun findAll(): List<Entity444> = repo.findAll()
    fun findByName(name: String): List<Entity444> = repo.findByField1(name)
    fun save(entity: Entity444): Entity444 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity444>): List<Entity444> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
