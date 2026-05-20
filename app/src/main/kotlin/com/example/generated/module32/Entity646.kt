package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_646")
data class Entity646(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity646Repository : org.springframework.data.jpa.repository.JpaRepository<Entity646, Long> {
    fun findByField1(field1: String): List<Entity646>
    fun findByField3GreaterThan(value: Int): List<Entity646>
}

@Service
@Transactional
class Service646(private val repo: Entity646Repository) {
    fun findAll(): List<Entity646> = repo.findAll()
    fun findByName(name: String): List<Entity646> = repo.findByField1(name)
    fun save(entity: Entity646): Entity646 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity646>): List<Entity646> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
