package com.example.generated.module24

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_491")
data class Entity491(
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

interface Entity491Repository : org.springframework.data.jpa.repository.JpaRepository<Entity491, Long> {
    fun findByField1(field1: String): List<Entity491>
    fun findByField3GreaterThan(value: Int): List<Entity491>
    fun findByField4(active: Boolean): List<Entity491>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity491>
}

@Service
@Transactional
class Service491(private val repo: Entity491Repository) {
    fun findAll(): List<Entity491> = repo.findAll()
    fun findByName(name: String): List<Entity491> = repo.findByField1(name)
    fun findActive(): List<Entity491> = repo.findByField4(true)
    fun search(query: String): List<Entity491> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity491): Entity491 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity491>): List<Entity491> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity491>): Map<String, List<Entity491>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity491): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity491")
class Controller491(private val service: Service491) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity491) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
