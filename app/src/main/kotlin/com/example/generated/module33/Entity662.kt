package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_662")
data class Entity662(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity662Repository : org.springframework.data.jpa.repository.JpaRepository<Entity662, Long> {
    fun findByField1(field1: String): List<Entity662>
    fun findByField3GreaterThan(value: Int): List<Entity662>
}

@Service
@Transactional
class Service662(private val repo: Entity662Repository) {
    fun findAll(): List<Entity662> = repo.findAll()
    fun findByName(name: String): List<Entity662> = repo.findByField1(name)
    fun save(entity: Entity662): Entity662 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity662>): List<Entity662> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
