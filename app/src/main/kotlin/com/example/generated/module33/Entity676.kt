package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_676")
data class Entity676(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity676Repository : org.springframework.data.jpa.repository.JpaRepository<Entity676, Long> {
    fun findByField1(field1: String): List<Entity676>
    fun findByField3GreaterThan(value: Int): List<Entity676>
}

@Service
@Transactional
class Service676(private val repo: Entity676Repository) {
    fun findAll(): List<Entity676> = repo.findAll()
    fun findByName(name: String): List<Entity676> = repo.findByField1(name)
    fun save(entity: Entity676): Entity676 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity676>): List<Entity676> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
