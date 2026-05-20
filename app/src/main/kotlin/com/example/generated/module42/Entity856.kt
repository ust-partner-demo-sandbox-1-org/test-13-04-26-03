package com.example.generated.module42

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_856")
data class Entity856(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity856Repository : org.springframework.data.jpa.repository.JpaRepository<Entity856, Long> {
    fun findByField1(field1: String): List<Entity856>
    fun findByField3GreaterThan(value: Int): List<Entity856>
}

@Service
@Transactional
class Service856(private val repo: Entity856Repository) {
    fun findAll(): List<Entity856> = repo.findAll()
    fun findByName(name: String): List<Entity856> = repo.findByField1(name)
    fun save(entity: Entity856): Entity856 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity856>): List<Entity856> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
