package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_669")
data class Entity669(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity669Repository : org.springframework.data.jpa.repository.JpaRepository<Entity669, Long> {
    fun findByField1(field1: String): List<Entity669>
    fun findByField3GreaterThan(value: Int): List<Entity669>
}

@Service
@Transactional
class Service669(private val repo: Entity669Repository) {
    fun findAll(): List<Entity669> = repo.findAll()
    fun findByName(name: String): List<Entity669> = repo.findByField1(name)
    fun save(entity: Entity669): Entity669 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity669>): List<Entity669> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
