package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_44")
data class Entity44(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity44Repository : org.springframework.data.jpa.repository.JpaRepository<Entity44, Long> {
    fun findByField1(field1: String): List<Entity44>
    fun findByField3GreaterThan(value: Int): List<Entity44>
}

@Service
@Transactional
class Service44(private val repo: Entity44Repository) {
    fun findAll(): List<Entity44> = repo.findAll()
    fun findByName(name: String): List<Entity44> = repo.findByField1(name)
    fun save(entity: Entity44): Entity44 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity44>): List<Entity44> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
