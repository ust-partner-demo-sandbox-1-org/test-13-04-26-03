package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_638")
data class Entity638(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity638Repository : org.springframework.data.jpa.repository.JpaRepository<Entity638, Long> {
    fun findByField1(field1: String): List<Entity638>
    fun findByField3GreaterThan(value: Int): List<Entity638>
}

@Service
@Transactional
class Service638(private val repo: Entity638Repository) {
    fun findAll(): List<Entity638> = repo.findAll()
    fun findByName(name: String): List<Entity638> = repo.findByField1(name)
    fun save(entity: Entity638): Entity638 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity638>): List<Entity638> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
