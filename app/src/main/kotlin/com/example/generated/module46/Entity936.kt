package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_936")
data class Entity936(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity936Repository : org.springframework.data.jpa.repository.JpaRepository<Entity936, Long> {
    fun findByField1(field1: String): List<Entity936>
    fun findByField3GreaterThan(value: Int): List<Entity936>
}

@Service
@Transactional
class Service936(private val repo: Entity936Repository) {
    fun findAll(): List<Entity936> = repo.findAll()
    fun findByName(name: String): List<Entity936> = repo.findByField1(name)
    fun save(entity: Entity936): Entity936 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity936>): List<Entity936> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
