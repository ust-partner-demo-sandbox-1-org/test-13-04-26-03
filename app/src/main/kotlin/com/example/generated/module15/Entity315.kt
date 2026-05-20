package com.example.generated.module15

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_315")
data class Entity315(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity315Repository : org.springframework.data.jpa.repository.JpaRepository<Entity315, Long> {
    fun findByField1(field1: String): List<Entity315>
    fun findByField3GreaterThan(value: Int): List<Entity315>
}

@Service
@Transactional
class Service315(private val repo: Entity315Repository) {
    fun findAll(): List<Entity315> = repo.findAll()
    fun findByName(name: String): List<Entity315> = repo.findByField1(name)
    fun save(entity: Entity315): Entity315 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity315>): List<Entity315> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
