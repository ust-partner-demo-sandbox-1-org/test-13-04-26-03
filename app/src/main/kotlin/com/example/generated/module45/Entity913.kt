package com.example.generated.module45

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_913")
data class Entity913(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity913Repository : org.springframework.data.jpa.repository.JpaRepository<Entity913, Long> {
    fun findByField1(field1: String): List<Entity913>
    fun findByField3GreaterThan(value: Int): List<Entity913>
}

@Service
@Transactional
class Service913(private val repo: Entity913Repository) {
    fun findAll(): List<Entity913> = repo.findAll()
    fun findByName(name: String): List<Entity913> = repo.findByField1(name)
    fun save(entity: Entity913): Entity913 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity913>): List<Entity913> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
