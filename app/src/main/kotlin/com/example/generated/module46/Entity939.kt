package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_939")
data class Entity939(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity939Repository : org.springframework.data.jpa.repository.JpaRepository<Entity939, Long> {
    fun findByField1(field1: String): List<Entity939>
    fun findByField3GreaterThan(value: Int): List<Entity939>
}

@Service
@Transactional
class Service939(private val repo: Entity939Repository) {
    fun findAll(): List<Entity939> = repo.findAll()
    fun findByName(name: String): List<Entity939> = repo.findByField1(name)
    fun save(entity: Entity939): Entity939 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity939>): List<Entity939> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
