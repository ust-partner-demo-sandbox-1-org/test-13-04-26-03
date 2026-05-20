package com.example.generated.module4

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_84")
data class Entity84(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val field1: String = "",
    val field2: String? = null,
    val field3: Int = 0,
    val field4: Boolean = false,
    @Column(columnDefinition = "TEXT")
    val field5: String? = null,
    val field6: Double = 0.0,
    val field7: String? = null,
    val field8: Long = 0,
    val field9: Boolean = true,
    @Column(columnDefinition = "TEXT")
    val field10: String? = null
)

interface Entity84Repository : org.springframework.data.jpa.repository.JpaRepository<Entity84, Long> {
    fun findByField1(field1: String): List<Entity84>
    fun findByField3GreaterThan(value: Int): List<Entity84>
    fun findByField4(active: Boolean): List<Entity84>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity84>
}

@Service
@Transactional
class Service84(private val repo: Entity84Repository) {
    fun findAll(): List<Entity84> = repo.findAll()
    fun findByName(name: String): List<Entity84> = repo.findByField1(name)
    fun findActive(): List<Entity84> = repo.findByField4(true)
    fun search(query: String): List<Entity84> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity84): Entity84 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity84>): List<Entity84> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity84>): Map<String, List<Entity84>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity84): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity84")
class Controller84(private val service: Service84) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity84) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
