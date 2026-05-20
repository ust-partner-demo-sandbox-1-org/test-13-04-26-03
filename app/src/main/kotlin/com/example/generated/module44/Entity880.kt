package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_880")
data class Entity880(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity880Repository : org.springframework.data.jpa.repository.JpaRepository<Entity880, Long> {
    fun findByField1(field1: String): List<Entity880>
    fun findByField3GreaterThan(value: Int): List<Entity880>
}

@Service
@Transactional
class Service880(private val repo: Entity880Repository) {
    fun findAll(): List<Entity880> = repo.findAll()
    fun findByName(name: String): List<Entity880> = repo.findByField1(name)
    fun save(entity: Entity880): Entity880 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity880>): List<Entity880> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
