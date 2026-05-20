package com.example.generated.module27

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_559")
data class Entity559(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity559Repository : org.springframework.data.jpa.repository.JpaRepository<Entity559, Long> {
    fun findByField1(field1: String): List<Entity559>
    fun findByField3GreaterThan(value: Int): List<Entity559>
}

@Service
@Transactional
class Service559(private val repo: Entity559Repository) {
    fun findAll(): List<Entity559> = repo.findAll()
    fun findByName(name: String): List<Entity559> = repo.findByField1(name)
    fun save(entity: Entity559): Entity559 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity559>): List<Entity559> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
