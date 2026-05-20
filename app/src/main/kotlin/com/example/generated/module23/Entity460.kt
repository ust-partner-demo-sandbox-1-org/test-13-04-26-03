package com.example.generated.module23

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_460")
data class Entity460(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity460Repository : org.springframework.data.jpa.repository.JpaRepository<Entity460, Long> {
    fun findByField1(field1: String): List<Entity460>
    fun findByField3GreaterThan(value: Int): List<Entity460>
}

@Service
@Transactional
class Service460(private val repo: Entity460Repository) {
    fun findAll(): List<Entity460> = repo.findAll()
    fun findByName(name: String): List<Entity460> = repo.findByField1(name)
    fun save(entity: Entity460): Entity460 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity460>): List<Entity460> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
