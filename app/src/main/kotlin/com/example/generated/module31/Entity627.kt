package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_627")
data class Entity627(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity627Repository : org.springframework.data.jpa.repository.JpaRepository<Entity627, Long> {
    fun findByField1(field1: String): List<Entity627>
    fun findByField3GreaterThan(value: Int): List<Entity627>
}

@Service
@Transactional
class Service627(private val repo: Entity627Repository) {
    fun findAll(): List<Entity627> = repo.findAll()
    fun findByName(name: String): List<Entity627> = repo.findByField1(name)
    fun save(entity: Entity627): Entity627 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity627>): List<Entity627> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
