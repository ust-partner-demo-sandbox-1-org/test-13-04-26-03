package com.example.generated.module1

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_35")
data class Entity35(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity35Repository : org.springframework.data.jpa.repository.JpaRepository<Entity35, Long> {
    fun findByField1(field1: String): List<Entity35>
    fun findByField3GreaterThan(value: Int): List<Entity35>
}

@Service
@Transactional
class Service35(private val repo: Entity35Repository) {
    fun findAll(): List<Entity35> = repo.findAll()
    fun findByName(name: String): List<Entity35> = repo.findByField1(name)
    fun save(entity: Entity35): Entity35 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity35>): List<Entity35> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
