package com.example.generated.module43

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_866")
data class Entity866(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity866Repository : org.springframework.data.jpa.repository.JpaRepository<Entity866, Long> {
    fun findByField1(field1: String): List<Entity866>
    fun findByField3GreaterThan(value: Int): List<Entity866>
}

@Service
@Transactional
class Service866(private val repo: Entity866Repository) {
    fun findAll(): List<Entity866> = repo.findAll()
    fun findByName(name: String): List<Entity866> = repo.findByField1(name)
    fun save(entity: Entity866): Entity866 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity866>): List<Entity866> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
