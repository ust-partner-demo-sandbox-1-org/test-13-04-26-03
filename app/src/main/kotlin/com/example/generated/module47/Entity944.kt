package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_944")
data class Entity944(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity944Repository : org.springframework.data.jpa.repository.JpaRepository<Entity944, Long> {
    fun findByField1(field1: String): List<Entity944>
    fun findByField3GreaterThan(value: Int): List<Entity944>
}

@Service
@Transactional
class Service944(private val repo: Entity944Repository) {
    fun findAll(): List<Entity944> = repo.findAll()
    fun findByName(name: String): List<Entity944> = repo.findByField1(name)
    fun save(entity: Entity944): Entity944 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity944>): List<Entity944> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
