package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_953")
data class Entity953(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity953Repository : org.springframework.data.jpa.repository.JpaRepository<Entity953, Long> {
    fun findByField1(field1: String): List<Entity953>
    fun findByField3GreaterThan(value: Int): List<Entity953>
}

@Service
@Transactional
class Service953(private val repo: Entity953Repository) {
    fun findAll(): List<Entity953> = repo.findAll()
    fun findByName(name: String): List<Entity953> = repo.findByField1(name)
    fun save(entity: Entity953): Entity953 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity953>): List<Entity953> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
