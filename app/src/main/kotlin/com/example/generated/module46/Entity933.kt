package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_933")
data class Entity933(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity933Repository : org.springframework.data.jpa.repository.JpaRepository<Entity933, Long> {
    fun findByField1(field1: String): List<Entity933>
    fun findByField3GreaterThan(value: Int): List<Entity933>
}

@Service
@Transactional
class Service933(private val repo: Entity933Repository) {
    fun findAll(): List<Entity933> = repo.findAll()
    fun findByName(name: String): List<Entity933> = repo.findByField1(name)
    fun save(entity: Entity933): Entity933 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity933>): List<Entity933> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
