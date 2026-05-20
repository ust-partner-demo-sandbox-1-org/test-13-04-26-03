package com.example.generated.module41

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_837")
data class Entity837(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity837Repository : org.springframework.data.jpa.repository.JpaRepository<Entity837, Long> {
    fun findByField1(field1: String): List<Entity837>
    fun findByField3GreaterThan(value: Int): List<Entity837>
}

@Service
@Transactional
class Service837(private val repo: Entity837Repository) {
    fun findAll(): List<Entity837> = repo.findAll()
    fun findByName(name: String): List<Entity837> = repo.findByField1(name)
    fun save(entity: Entity837): Entity837 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity837>): List<Entity837> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
