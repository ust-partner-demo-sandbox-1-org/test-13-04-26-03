package com.example.generated.module16

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_338")
data class Entity338(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity338Repository : org.springframework.data.jpa.repository.JpaRepository<Entity338, Long> {
    fun findByField1(field1: String): List<Entity338>
    fun findByField3GreaterThan(value: Int): List<Entity338>
}

@Service
@Transactional
class Service338(private val repo: Entity338Repository) {
    fun findAll(): List<Entity338> = repo.findAll()
    fun findByName(name: String): List<Entity338> = repo.findByField1(name)
    fun save(entity: Entity338): Entity338 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity338>): List<Entity338> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
