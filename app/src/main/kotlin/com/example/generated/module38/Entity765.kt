package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_765")
data class Entity765(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity765Repository : org.springframework.data.jpa.repository.JpaRepository<Entity765, Long> {
    fun findByField1(field1: String): List<Entity765>
    fun findByField3GreaterThan(value: Int): List<Entity765>
}

@Service
@Transactional
class Service765(private val repo: Entity765Repository) {
    fun findAll(): List<Entity765> = repo.findAll()
    fun findByName(name: String): List<Entity765> = repo.findByField1(name)
    fun save(entity: Entity765): Entity765 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity765>): List<Entity765> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
