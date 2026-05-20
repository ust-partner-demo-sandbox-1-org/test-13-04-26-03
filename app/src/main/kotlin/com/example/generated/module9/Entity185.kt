package com.example.generated.module9

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_185")
data class Entity185(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity185Repository : org.springframework.data.jpa.repository.JpaRepository<Entity185, Long> {
    fun findByField1(field1: String): List<Entity185>
    fun findByField3GreaterThan(value: Int): List<Entity185>
}

@Service
@Transactional
class Service185(private val repo: Entity185Repository) {
    fun findAll(): List<Entity185> = repo.findAll()
    fun findByName(name: String): List<Entity185> = repo.findByField1(name)
    fun save(entity: Entity185): Entity185 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity185>): List<Entity185> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
