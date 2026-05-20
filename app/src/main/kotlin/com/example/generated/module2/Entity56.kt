package com.example.generated.module2

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_56")
data class Entity56(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity56Repository : org.springframework.data.jpa.repository.JpaRepository<Entity56, Long> {
    fun findByField1(field1: String): List<Entity56>
    fun findByField3GreaterThan(value: Int): List<Entity56>
}

@Service
@Transactional
class Service56(private val repo: Entity56Repository) {
    fun findAll(): List<Entity56> = repo.findAll()
    fun findByName(name: String): List<Entity56> = repo.findByField1(name)
    fun save(entity: Entity56): Entity56 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity56>): List<Entity56> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
