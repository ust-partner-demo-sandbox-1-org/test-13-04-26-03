package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_639")
data class Entity639(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity639Repository : org.springframework.data.jpa.repository.JpaRepository<Entity639, Long> {
    fun findByField1(field1: String): List<Entity639>
    fun findByField3GreaterThan(value: Int): List<Entity639>
}

@Service
@Transactional
class Service639(private val repo: Entity639Repository) {
    fun findAll(): List<Entity639> = repo.findAll()
    fun findByName(name: String): List<Entity639> = repo.findByField1(name)
    fun save(entity: Entity639): Entity639 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity639>): List<Entity639> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
