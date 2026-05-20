package com.example.generated.module37

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_748")
data class Entity748(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity748Repository : org.springframework.data.jpa.repository.JpaRepository<Entity748, Long> {
    fun findByField1(field1: String): List<Entity748>
    fun findByField3GreaterThan(value: Int): List<Entity748>
}

@Service
@Transactional
class Service748(private val repo: Entity748Repository) {
    fun findAll(): List<Entity748> = repo.findAll()
    fun findByName(name: String): List<Entity748> = repo.findByField1(name)
    fun save(entity: Entity748): Entity748 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity748>): List<Entity748> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
