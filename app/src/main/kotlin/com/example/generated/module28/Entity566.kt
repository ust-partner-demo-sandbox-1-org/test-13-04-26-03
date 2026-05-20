package com.example.generated.module28

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_566")
data class Entity566(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity566Repository : org.springframework.data.jpa.repository.JpaRepository<Entity566, Long> {
    fun findByField1(field1: String): List<Entity566>
    fun findByField3GreaterThan(value: Int): List<Entity566>
}

@Service
@Transactional
class Service566(private val repo: Entity566Repository) {
    fun findAll(): List<Entity566> = repo.findAll()
    fun findByName(name: String): List<Entity566> = repo.findByField1(name)
    fun save(entity: Entity566): Entity566 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity566>): List<Entity566> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
