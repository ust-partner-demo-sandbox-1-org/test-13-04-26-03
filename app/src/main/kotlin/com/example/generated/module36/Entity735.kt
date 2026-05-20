package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_735")
data class Entity735(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity735Repository : org.springframework.data.jpa.repository.JpaRepository<Entity735, Long> {
    fun findByField1(field1: String): List<Entity735>
    fun findByField3GreaterThan(value: Int): List<Entity735>
}

@Service
@Transactional
class Service735(private val repo: Entity735Repository) {
    fun findAll(): List<Entity735> = repo.findAll()
    fun findByName(name: String): List<Entity735> = repo.findByField1(name)
    fun save(entity: Entity735): Entity735 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity735>): List<Entity735> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
