package com.example.generated.module13

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_260")
data class Entity260(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity260Repository : org.springframework.data.jpa.repository.JpaRepository<Entity260, Long> {
    fun findByField1(field1: String): List<Entity260>
    fun findByField3GreaterThan(value: Int): List<Entity260>
}

@Service
@Transactional
class Service260(private val repo: Entity260Repository) {
    fun findAll(): List<Entity260> = repo.findAll()
    fun findByName(name: String): List<Entity260> = repo.findByField1(name)
    fun save(entity: Entity260): Entity260 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity260>): List<Entity260> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
