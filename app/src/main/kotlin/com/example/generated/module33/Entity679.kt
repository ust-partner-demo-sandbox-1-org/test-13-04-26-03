package com.example.generated.module33

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_679")
data class Entity679(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity679Repository : org.springframework.data.jpa.repository.JpaRepository<Entity679, Long> {
    fun findByField1(field1: String): List<Entity679>
    fun findByField3GreaterThan(value: Int): List<Entity679>
}

@Service
@Transactional
class Service679(private val repo: Entity679Repository) {
    fun findAll(): List<Entity679> = repo.findAll()
    fun findByName(name: String): List<Entity679> = repo.findByField1(name)
    fun save(entity: Entity679): Entity679 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity679>): List<Entity679> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
