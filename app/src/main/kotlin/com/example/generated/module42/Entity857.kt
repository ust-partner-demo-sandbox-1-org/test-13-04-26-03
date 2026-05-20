package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_857")
data class Entity857(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity857Repository : org.springframework.data.jpa.repository.JpaRepository<Entity857, Long> {
    fun findByField1(field1: String): List<Entity857>
    fun findByField3GreaterThan(value: Int): List<Entity857>
}

@Service
@Transactional
class Service857(private val repo: Entity857Repository) {
    fun findAll(): List<Entity857> = repo.findAll()
    fun findByName(name: String): List<Entity857> = repo.findByField1(name)
    fun save(entity: Entity857): Entity857 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity857>): List<Entity857> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
