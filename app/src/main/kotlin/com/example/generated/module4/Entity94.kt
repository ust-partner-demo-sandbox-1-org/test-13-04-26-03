package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_94")
data class Entity94(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity94Repository : org.springframework.data.jpa.repository.JpaRepository<Entity94, Long> {
    fun findByField1(field1: String): List<Entity94>
    fun findByField3GreaterThan(value: Int): List<Entity94>
}

@Service
@Transactional
class Service94(private val repo: Entity94Repository) {
    fun findAll(): List<Entity94> = repo.findAll()
    fun findByName(name: String): List<Entity94> = repo.findByField1(name)
    fun save(entity: Entity94): Entity94 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity94>): List<Entity94> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
