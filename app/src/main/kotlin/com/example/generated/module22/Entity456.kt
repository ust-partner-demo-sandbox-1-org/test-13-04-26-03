package com.example.generated.module22

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_456")
data class Entity456(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity456Repository : org.springframework.data.jpa.repository.JpaRepository<Entity456, Long> {
    fun findByField1(field1: String): List<Entity456>
    fun findByField3GreaterThan(value: Int): List<Entity456>
}

@Service
@Transactional
class Service456(private val repo: Entity456Repository) {
    fun findAll(): List<Entity456> = repo.findAll()
    fun findByName(name: String): List<Entity456> = repo.findByField1(name)
    fun save(entity: Entity456): Entity456 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity456>): List<Entity456> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
