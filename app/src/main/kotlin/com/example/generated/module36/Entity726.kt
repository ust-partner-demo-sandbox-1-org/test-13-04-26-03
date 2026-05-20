package com.example.generated.module36

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_726")
data class Entity726(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity726Repository : org.springframework.data.jpa.repository.JpaRepository<Entity726, Long> {
    fun findByField1(field1: String): List<Entity726>
    fun findByField3GreaterThan(value: Int): List<Entity726>
}

@Service
@Transactional
class Service726(private val repo: Entity726Repository) {
    fun findAll(): List<Entity726> = repo.findAll()
    fun findByName(name: String): List<Entity726> = repo.findByField1(name)
    fun save(entity: Entity726): Entity726 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity726>): List<Entity726> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
