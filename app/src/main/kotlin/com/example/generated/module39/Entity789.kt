package com.example.generated.module39

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_789")
data class Entity789(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity789Repository : org.springframework.data.jpa.repository.JpaRepository<Entity789, Long> {
    fun findByField1(field1: String): List<Entity789>
    fun findByField3GreaterThan(value: Int): List<Entity789>
}

@Service
@Transactional
class Service789(private val repo: Entity789Repository) {
    fun findAll(): List<Entity789> = repo.findAll()
    fun findByName(name: String): List<Entity789> = repo.findByField1(name)
    fun save(entity: Entity789): Entity789 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity789>): List<Entity789> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
