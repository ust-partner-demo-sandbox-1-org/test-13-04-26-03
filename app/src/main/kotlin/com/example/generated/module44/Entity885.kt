package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_885")
data class Entity885(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity885Repository : org.springframework.data.jpa.repository.JpaRepository<Entity885, Long> {
    fun findByField1(field1: String): List<Entity885>
    fun findByField3GreaterThan(value: Int): List<Entity885>
}

@Service
@Transactional
class Service885(private val repo: Entity885Repository) {
    fun findAll(): List<Entity885> = repo.findAll()
    fun findByName(name: String): List<Entity885> = repo.findByField1(name)
    fun save(entity: Entity885): Entity885 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity885>): List<Entity885> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
