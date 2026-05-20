package com.example.generated.module7

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_143")
data class Entity143(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity143Repository : org.springframework.data.jpa.repository.JpaRepository<Entity143, Long> {
    fun findByField1(field1: String): List<Entity143>
    fun findByField3GreaterThan(value: Int): List<Entity143>
}

@Service
@Transactional
class Service143(private val repo: Entity143Repository) {
    fun findAll(): List<Entity143> = repo.findAll()
    fun findByName(name: String): List<Entity143> = repo.findByField1(name)
    fun save(entity: Entity143): Entity143 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity143>): List<Entity143> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
