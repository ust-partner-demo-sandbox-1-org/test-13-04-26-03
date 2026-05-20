package com.example.generated.module12

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_249")
data class Entity249(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity249Repository : org.springframework.data.jpa.repository.JpaRepository<Entity249, Long> {
    fun findByField1(field1: String): List<Entity249>
    fun findByField3GreaterThan(value: Int): List<Entity249>
}

@Service
@Transactional
class Service249(private val repo: Entity249Repository) {
    fun findAll(): List<Entity249> = repo.findAll()
    fun findByName(name: String): List<Entity249> = repo.findByField1(name)
    fun save(entity: Entity249): Entity249 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity249>): List<Entity249> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
