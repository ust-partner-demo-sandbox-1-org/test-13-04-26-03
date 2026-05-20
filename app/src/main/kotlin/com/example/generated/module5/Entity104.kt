package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_104")
data class Entity104(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity104Repository : org.springframework.data.jpa.repository.JpaRepository<Entity104, Long> {
    fun findByField1(field1: String): List<Entity104>
    fun findByField3GreaterThan(value: Int): List<Entity104>
}

@Service
@Transactional
class Service104(private val repo: Entity104Repository) {
    fun findAll(): List<Entity104> = repo.findAll()
    fun findByName(name: String): List<Entity104> = repo.findByField1(name)
    fun save(entity: Entity104): Entity104 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity104>): List<Entity104> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
