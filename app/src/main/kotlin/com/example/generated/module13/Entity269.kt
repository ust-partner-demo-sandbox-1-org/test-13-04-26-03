package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_269")
data class Entity269(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity269Repository : org.springframework.data.jpa.repository.JpaRepository<Entity269, Long> {
    fun findByField1(field1: String): List<Entity269>
    fun findByField3GreaterThan(value: Int): List<Entity269>
}

@Service
@Transactional
class Service269(private val repo: Entity269Repository) {
    fun findAll(): List<Entity269> = repo.findAll()
    fun findByName(name: String): List<Entity269> = repo.findByField1(name)
    fun save(entity: Entity269): Entity269 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity269>): List<Entity269> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
