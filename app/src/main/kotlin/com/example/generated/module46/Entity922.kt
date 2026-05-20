package com.example.generated.module46

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_922")
data class Entity922(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity922Repository : org.springframework.data.jpa.repository.JpaRepository<Entity922, Long> {
    fun findByField1(field1: String): List<Entity922>
    fun findByField3GreaterThan(value: Int): List<Entity922>
}

@Service
@Transactional
class Service922(private val repo: Entity922Repository) {
    fun findAll(): List<Entity922> = repo.findAll()
    fun findByName(name: String): List<Entity922> = repo.findByField1(name)
    fun save(entity: Entity922): Entity922 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity922>): List<Entity922> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
