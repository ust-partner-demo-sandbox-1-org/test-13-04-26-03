package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_291")
data class Entity291(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity291Repository : org.springframework.data.jpa.repository.JpaRepository<Entity291, Long> {
    fun findByField1(field1: String): List<Entity291>
    fun findByField3GreaterThan(value: Int): List<Entity291>
}

@Service
@Transactional
class Service291(private val repo: Entity291Repository) {
    fun findAll(): List<Entity291> = repo.findAll()
    fun findByName(name: String): List<Entity291> = repo.findByField1(name)
    fun save(entity: Entity291): Entity291 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity291>): List<Entity291> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
