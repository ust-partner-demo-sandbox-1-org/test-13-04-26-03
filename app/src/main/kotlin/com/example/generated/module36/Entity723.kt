package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_723")
data class Entity723(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity723Repository : org.springframework.data.jpa.repository.JpaRepository<Entity723, Long> {
    fun findByField1(field1: String): List<Entity723>
    fun findByField3GreaterThan(value: Int): List<Entity723>
}

@Service
@Transactional
class Service723(private val repo: Entity723Repository) {
    fun findAll(): List<Entity723> = repo.findAll()
    fun findByName(name: String): List<Entity723> = repo.findByField1(name)
    fun save(entity: Entity723): Entity723 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity723>): List<Entity723> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
