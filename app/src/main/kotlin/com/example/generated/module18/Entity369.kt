package com.example.generated.module18

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_369")
data class Entity369(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity369Repository : org.springframework.data.jpa.repository.JpaRepository<Entity369, Long> {
    fun findByField1(field1: String): List<Entity369>
    fun findByField3GreaterThan(value: Int): List<Entity369>
}

@Service
@Transactional
class Service369(private val repo: Entity369Repository) {
    fun findAll(): List<Entity369> = repo.findAll()
    fun findByName(name: String): List<Entity369> = repo.findByField1(name)
    fun save(entity: Entity369): Entity369 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity369>): List<Entity369> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
