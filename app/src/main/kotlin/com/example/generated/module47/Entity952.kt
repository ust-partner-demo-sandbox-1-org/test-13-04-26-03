package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_952")
data class Entity952(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity952Repository : org.springframework.data.jpa.repository.JpaRepository<Entity952, Long> {
    fun findByField1(field1: String): List<Entity952>
    fun findByField3GreaterThan(value: Int): List<Entity952>
}

@Service
@Transactional
class Service952(private val repo: Entity952Repository) {
    fun findAll(): List<Entity952> = repo.findAll()
    fun findByName(name: String): List<Entity952> = repo.findByField1(name)
    fun save(entity: Entity952): Entity952 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity952>): List<Entity952> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
