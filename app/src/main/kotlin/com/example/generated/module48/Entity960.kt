package com.example.generated.module48

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_960")
data class Entity960(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity960Repository : org.springframework.data.jpa.repository.JpaRepository<Entity960, Long> {
    fun findByField1(field1: String): List<Entity960>
    fun findByField3GreaterThan(value: Int): List<Entity960>
}

@Service
@Transactional
class Service960(private val repo: Entity960Repository) {
    fun findAll(): List<Entity960> = repo.findAll()
    fun findByName(name: String): List<Entity960> = repo.findByField1(name)
    fun save(entity: Entity960): Entity960 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity960>): List<Entity960> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
