package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_675")
data class Entity675(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity675Repository : org.springframework.data.jpa.repository.JpaRepository<Entity675, Long> {
    fun findByField1(field1: String): List<Entity675>
    fun findByField3GreaterThan(value: Int): List<Entity675>
}

@Service
@Transactional
class Service675(private val repo: Entity675Repository) {
    fun findAll(): List<Entity675> = repo.findAll()
    fun findByName(name: String): List<Entity675> = repo.findByField1(name)
    fun save(entity: Entity675): Entity675 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity675>): List<Entity675> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
