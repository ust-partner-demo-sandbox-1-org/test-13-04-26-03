package com.example.generated.module31

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_624")
data class Entity624(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity624Repository : org.springframework.data.jpa.repository.JpaRepository<Entity624, Long> {
    fun findByField1(field1: String): List<Entity624>
    fun findByField3GreaterThan(value: Int): List<Entity624>
}

@Service
@Transactional
class Service624(private val repo: Entity624Repository) {
    fun findAll(): List<Entity624> = repo.findAll()
    fun findByName(name: String): List<Entity624> = repo.findByField1(name)
    fun save(entity: Entity624): Entity624 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity624>): List<Entity624> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
