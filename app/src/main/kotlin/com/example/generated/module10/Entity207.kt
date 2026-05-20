package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_207")
data class Entity207(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity207Repository : org.springframework.data.jpa.repository.JpaRepository<Entity207, Long> {
    fun findByField1(field1: String): List<Entity207>
    fun findByField3GreaterThan(value: Int): List<Entity207>
}

@Service
@Transactional
class Service207(private val repo: Entity207Repository) {
    fun findAll(): List<Entity207> = repo.findAll()
    fun findByName(name: String): List<Entity207> = repo.findByField1(name)
    fun save(entity: Entity207): Entity207 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity207>): List<Entity207> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
