package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_720")
data class Entity720(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity720Repository : org.springframework.data.jpa.repository.JpaRepository<Entity720, Long> {
    fun findByField1(field1: String): List<Entity720>
    fun findByField3GreaterThan(value: Int): List<Entity720>
}

@Service
@Transactional
class Service720(private val repo: Entity720Repository) {
    fun findAll(): List<Entity720> = repo.findAll()
    fun findByName(name: String): List<Entity720> = repo.findByField1(name)
    fun save(entity: Entity720): Entity720 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity720>): List<Entity720> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
