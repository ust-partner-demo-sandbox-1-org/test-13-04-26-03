package com.example.generated.module32

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_651")
data class Entity651(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity651Repository : org.springframework.data.jpa.repository.JpaRepository<Entity651, Long> {
    fun findByField1(field1: String): List<Entity651>
    fun findByField3GreaterThan(value: Int): List<Entity651>
}

@Service
@Transactional
class Service651(private val repo: Entity651Repository) {
    fun findAll(): List<Entity651> = repo.findAll()
    fun findByName(name: String): List<Entity651> = repo.findByField1(name)
    fun save(entity: Entity651): Entity651 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity651>): List<Entity651> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
