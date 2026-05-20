package com.example.generated.module34

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_680")
data class Entity680(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity680Repository : org.springframework.data.jpa.repository.JpaRepository<Entity680, Long> {
    fun findByField1(field1: String): List<Entity680>
    fun findByField3GreaterThan(value: Int): List<Entity680>
}

@Service
@Transactional
class Service680(private val repo: Entity680Repository) {
    fun findAll(): List<Entity680> = repo.findAll()
    fun findByName(name: String): List<Entity680> = repo.findByField1(name)
    fun save(entity: Entity680): Entity680 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity680>): List<Entity680> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
