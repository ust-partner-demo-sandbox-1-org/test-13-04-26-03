package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_886")
data class Entity886(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity886Repository : org.springframework.data.jpa.repository.JpaRepository<Entity886, Long> {
    fun findByField1(field1: String): List<Entity886>
    fun findByField3GreaterThan(value: Int): List<Entity886>
}

@Service
@Transactional
class Service886(private val repo: Entity886Repository) {
    fun findAll(): List<Entity886> = repo.findAll()
    fun findByName(name: String): List<Entity886> = repo.findByField1(name)
    fun save(entity: Entity886): Entity886 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity886>): List<Entity886> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
