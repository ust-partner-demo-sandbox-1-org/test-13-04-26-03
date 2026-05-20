package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_660")
data class Entity660(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity660Repository : org.springframework.data.jpa.repository.JpaRepository<Entity660, Long> {
    fun findByField1(field1: String): List<Entity660>
    fun findByField3GreaterThan(value: Int): List<Entity660>
}

@Service
@Transactional
class Service660(private val repo: Entity660Repository) {
    fun findAll(): List<Entity660> = repo.findAll()
    fun findByName(name: String): List<Entity660> = repo.findByField1(name)
    fun save(entity: Entity660): Entity660 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity660>): List<Entity660> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
