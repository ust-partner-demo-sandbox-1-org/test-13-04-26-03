package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_641")
data class Entity641(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity641Repository : org.springframework.data.jpa.repository.JpaRepository<Entity641, Long> {
    fun findByField1(field1: String): List<Entity641>
    fun findByField3GreaterThan(value: Int): List<Entity641>
}

@Service
@Transactional
class Service641(private val repo: Entity641Repository) {
    fun findAll(): List<Entity641> = repo.findAll()
    fun findByName(name: String): List<Entity641> = repo.findByField1(name)
    fun save(entity: Entity641): Entity641 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity641>): List<Entity641> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
