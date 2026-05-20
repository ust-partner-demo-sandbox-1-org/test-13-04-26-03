package com.example.generated.module26

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_520")
data class Entity520(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity520Repository : org.springframework.data.jpa.repository.JpaRepository<Entity520, Long> {
    fun findByField1(field1: String): List<Entity520>
    fun findByField3GreaterThan(value: Int): List<Entity520>
}

@Service
@Transactional
class Service520(private val repo: Entity520Repository) {
    fun findAll(): List<Entity520> = repo.findAll()
    fun findByName(name: String): List<Entity520> = repo.findByField1(name)
    fun save(entity: Entity520): Entity520 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity520>): List<Entity520> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
