package com.example.generated.module38

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_779")
data class Entity779(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity779Repository : org.springframework.data.jpa.repository.JpaRepository<Entity779, Long> {
    fun findByField1(field1: String): List<Entity779>
    fun findByField3GreaterThan(value: Int): List<Entity779>
}

@Service
@Transactional
class Service779(private val repo: Entity779Repository) {
    fun findAll(): List<Entity779> = repo.findAll()
    fun findByName(name: String): List<Entity779> = repo.findByField1(name)
    fun save(entity: Entity779): Entity779 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity779>): List<Entity779> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
