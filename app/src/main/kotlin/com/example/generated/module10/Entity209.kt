package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_209")
data class Entity209(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity209Repository : org.springframework.data.jpa.repository.JpaRepository<Entity209, Long> {
    fun findByField1(field1: String): List<Entity209>
    fun findByField3GreaterThan(value: Int): List<Entity209>
}

@Service
@Transactional
class Service209(private val repo: Entity209Repository) {
    fun findAll(): List<Entity209> = repo.findAll()
    fun findByName(name: String): List<Entity209> = repo.findByField1(name)
    fun save(entity: Entity209): Entity209 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity209>): List<Entity209> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
