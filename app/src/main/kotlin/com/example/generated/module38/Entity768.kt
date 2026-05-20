package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_768")
data class Entity768(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity768Repository : org.springframework.data.jpa.repository.JpaRepository<Entity768, Long> {
    fun findByField1(field1: String): List<Entity768>
    fun findByField3GreaterThan(value: Int): List<Entity768>
}

@Service
@Transactional
class Service768(private val repo: Entity768Repository) {
    fun findAll(): List<Entity768> = repo.findAll()
    fun findByName(name: String): List<Entity768> = repo.findByField1(name)
    fun save(entity: Entity768): Entity768 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity768>): List<Entity768> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
