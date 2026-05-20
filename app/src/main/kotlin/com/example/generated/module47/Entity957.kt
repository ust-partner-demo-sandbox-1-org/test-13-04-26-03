package com.example.generated.module47

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_957")
data class Entity957(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity957Repository : org.springframework.data.jpa.repository.JpaRepository<Entity957, Long> {
    fun findByField1(field1: String): List<Entity957>
    fun findByField3GreaterThan(value: Int): List<Entity957>
}

@Service
@Transactional
class Service957(private val repo: Entity957Repository) {
    fun findAll(): List<Entity957> = repo.findAll()
    fun findByName(name: String): List<Entity957> = repo.findByField1(name)
    fun save(entity: Entity957): Entity957 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity957>): List<Entity957> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
