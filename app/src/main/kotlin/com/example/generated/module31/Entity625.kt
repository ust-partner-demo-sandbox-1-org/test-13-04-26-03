package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_625")
data class Entity625(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity625Repository : org.springframework.data.jpa.repository.JpaRepository<Entity625, Long> {
    fun findByField1(field1: String): List<Entity625>
    fun findByField3GreaterThan(value: Int): List<Entity625>
}

@Service
@Transactional
class Service625(private val repo: Entity625Repository) {
    fun findAll(): List<Entity625> = repo.findAll()
    fun findByName(name: String): List<Entity625> = repo.findByField1(name)
    fun save(entity: Entity625): Entity625 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity625>): List<Entity625> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
