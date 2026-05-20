package com.example.generated.module10

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_205")
data class Entity205(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity205Repository : org.springframework.data.jpa.repository.JpaRepository<Entity205, Long> {
    fun findByField1(field1: String): List<Entity205>
    fun findByField3GreaterThan(value: Int): List<Entity205>
}

@Service
@Transactional
class Service205(private val repo: Entity205Repository) {
    fun findAll(): List<Entity205> = repo.findAll()
    fun findByName(name: String): List<Entity205> = repo.findByField1(name)
    fun save(entity: Entity205): Entity205 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity205>): List<Entity205> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
