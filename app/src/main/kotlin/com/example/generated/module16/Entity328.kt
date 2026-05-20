package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_328")
data class Entity328(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity328Repository : org.springframework.data.jpa.repository.JpaRepository<Entity328, Long> {
    fun findByField1(field1: String): List<Entity328>
    fun findByField3GreaterThan(value: Int): List<Entity328>
}

@Service
@Transactional
class Service328(private val repo: Entity328Repository) {
    fun findAll(): List<Entity328> = repo.findAll()
    fun findByName(name: String): List<Entity328> = repo.findByField1(name)
    fun save(entity: Entity328): Entity328 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity328>): List<Entity328> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
