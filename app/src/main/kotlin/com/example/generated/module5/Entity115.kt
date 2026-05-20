package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_115")
data class Entity115(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity115Repository : org.springframework.data.jpa.repository.JpaRepository<Entity115, Long> {
    fun findByField1(field1: String): List<Entity115>
    fun findByField3GreaterThan(value: Int): List<Entity115>
}

@Service
@Transactional
class Service115(private val repo: Entity115Repository) {
    fun findAll(): List<Entity115> = repo.findAll()
    fun findByName(name: String): List<Entity115> = repo.findByField1(name)
    fun save(entity: Entity115): Entity115 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity115>): List<Entity115> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
