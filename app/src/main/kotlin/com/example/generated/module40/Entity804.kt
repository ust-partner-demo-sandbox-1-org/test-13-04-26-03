package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_804")
data class Entity804(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity804Repository : org.springframework.data.jpa.repository.JpaRepository<Entity804, Long> {
    fun findByField1(field1: String): List<Entity804>
    fun findByField3GreaterThan(value: Int): List<Entity804>
}

@Service
@Transactional
class Service804(private val repo: Entity804Repository) {
    fun findAll(): List<Entity804> = repo.findAll()
    fun findByName(name: String): List<Entity804> = repo.findByField1(name)
    fun save(entity: Entity804): Entity804 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity804>): List<Entity804> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
