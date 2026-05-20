package com.example.generated.module44

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_891")
data class Entity891(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity891Repository : org.springframework.data.jpa.repository.JpaRepository<Entity891, Long> {
    fun findByField1(field1: String): List<Entity891>
    fun findByField3GreaterThan(value: Int): List<Entity891>
}

@Service
@Transactional
class Service891(private val repo: Entity891Repository) {
    fun findAll(): List<Entity891> = repo.findAll()
    fun findByName(name: String): List<Entity891> = repo.findByField1(name)
    fun save(entity: Entity891): Entity891 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity891>): List<Entity891> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
