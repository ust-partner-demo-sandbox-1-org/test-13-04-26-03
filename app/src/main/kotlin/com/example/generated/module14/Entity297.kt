package com.example.generated.module14

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_297")
data class Entity297(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity297Repository : org.springframework.data.jpa.repository.JpaRepository<Entity297, Long> {
    fun findByField1(field1: String): List<Entity297>
    fun findByField3GreaterThan(value: Int): List<Entity297>
}

@Service
@Transactional
class Service297(private val repo: Entity297Repository) {
    fun findAll(): List<Entity297> = repo.findAll()
    fun findByName(name: String): List<Entity297> = repo.findByField1(name)
    fun save(entity: Entity297): Entity297 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity297>): List<Entity297> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
