package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_26")
data class Entity26(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity26Repository : org.springframework.data.jpa.repository.JpaRepository<Entity26, Long> {
    fun findByField1(field1: String): List<Entity26>
    fun findByField3GreaterThan(value: Int): List<Entity26>
}

@Service
@Transactional
class Service26(private val repo: Entity26Repository) {
    fun findAll(): List<Entity26> = repo.findAll()
    fun findByName(name: String): List<Entity26> = repo.findByField1(name)
    fun save(entity: Entity26): Entity26 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity26>): List<Entity26> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
