package com.example.generated.module5

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_118")
data class Entity118(
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

interface Entity118Repository : org.springframework.data.jpa.repository.JpaRepository<Entity118, Long> {
    fun findByField1(field1: String): List<Entity118>
    fun findByField3GreaterThan(value: Int): List<Entity118>
    fun findByField4(active: Boolean): List<Entity118>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity118>
}

@Service
@Transactional
class Service118(private val repo: Entity118Repository) {
    fun findAll(): List<Entity118> = repo.findAll()
    fun findByName(name: String): List<Entity118> = repo.findByField1(name)
    fun findActive(): List<Entity118> = repo.findByField4(true)
    fun search(query: String): List<Entity118> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity118): Entity118 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity118>): List<Entity118> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity118>): Map<String, List<Entity118>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity118): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity118")
class Controller118(private val service: Service118) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity118) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
