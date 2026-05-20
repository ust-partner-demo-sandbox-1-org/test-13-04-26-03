package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_108")
data class Entity108(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity108Repository : org.springframework.data.jpa.repository.JpaRepository<Entity108, Long> {
    fun findByField1(field1: String): List<Entity108>
    fun findByField3GreaterThan(value: Int): List<Entity108>
}

@Service
@Transactional
class Service108(private val repo: Entity108Repository) {
    fun findAll(): List<Entity108> = repo.findAll()
    fun findByName(name: String): List<Entity108> = repo.findByField1(name)
    fun save(entity: Entity108): Entity108 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity108>): List<Entity108> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
