package com.example.generated.module40

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*

@Entity
@Table(name = "entity_805")
data class Entity805(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null
)

interface Entity805Repository : org.springframework.data.jpa.repository.JpaRepository<Entity805, Long> {
    fun findByField1(field1: String): List<Entity805>
    fun findByField3GreaterThan(value: Int): List<Entity805>
}

@Service
@Transactional
class Service805(private val repo: Entity805Repository) {
    fun findAll(): List<Entity805> = repo.findAll()
    fun findByName(name: String): List<Entity805> = repo.findByField1(name)
    fun save(entity: Entity805): Entity805 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity805>): List<Entity805> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
}
