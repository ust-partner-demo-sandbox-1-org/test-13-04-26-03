package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_307")
data class Entity307(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity307Repository : org.springframework.data.jpa.repository.JpaRepository<Entity307, Long> {
    fun findByField1(field1: String): List<Entity307>
    fun findByField3GreaterThan(value: Int): List<Entity307>
}

@Service
@Transactional
class Service307(private val repo: Entity307Repository) {
    fun findAll(): List<Entity307> = repo.findAll()
    fun findByName(name: String): List<Entity307> = repo.findByField1(name)
    fun save(entity: Entity307): Entity307 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity307>): List<Entity307> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
