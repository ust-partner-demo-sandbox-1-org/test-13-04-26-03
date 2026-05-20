package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_286")
data class Entity286(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity286Repository : org.springframework.data.jpa.repository.JpaRepository<Entity286, Long> {
    fun findByField1(field1: String): List<Entity286>
    fun findByField3GreaterThan(value: Int): List<Entity286>
}

@Service
@Transactional
class Service286(private val repo: Entity286Repository) {
    fun findAll(): List<Entity286> = repo.findAll()
    fun findByName(name: String): List<Entity286> = repo.findByField1(name)
    fun save(entity: Entity286): Entity286 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity286>): List<Entity286> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
