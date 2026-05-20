package com.example.generated.module35

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_719")
data class Entity719(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity719Repository : org.springframework.data.jpa.repository.JpaRepository<Entity719, Long> {
    fun findByField1(field1: String): List<Entity719>
    fun findByField3GreaterThan(value: Int): List<Entity719>
}

@Service
@Transactional
class Service719(private val repo: Entity719Repository) {
    fun findAll(): List<Entity719> = repo.findAll()
    fun findByName(name: String): List<Entity719> = repo.findByField1(name)
    fun save(entity: Entity719): Entity719 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity719>): List<Entity719> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
