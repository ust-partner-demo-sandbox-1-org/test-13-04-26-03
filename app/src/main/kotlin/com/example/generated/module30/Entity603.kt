package com.example.generated.module30

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import jakarta.persistence.*
import org.springframework.web.bind.annotation.*

@Entity
@Table(name = "entity_603")
data class Entity603(
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

interface Entity603Repository : org.springframework.data.jpa.repository.JpaRepository<Entity603, Long> {
    fun findByField1(field1: String): List<Entity603>
    fun findByField3GreaterThan(value: Int): List<Entity603>
    fun findByField4(active: Boolean): List<Entity603>
    fun findByField1ContainingIgnoreCase(search: String): List<Entity603>
}

@Service
@Transactional
class Service603(private val repo: Entity603Repository) {
    fun findAll(): List<Entity603> = repo.findAll()
    fun findByName(name: String): List<Entity603> = repo.findByField1(name)
    fun findActive(): List<Entity603> = repo.findByField4(true)
    fun search(query: String): List<Entity603> = repo.findByField1ContainingIgnoreCase(query)
    fun save(entity: Entity603): Entity603 = repo.save(entity)
    fun delete(id: Long) = repo.deleteById(id)
    fun process(items: List<Entity603>): List<Entity603> {
        return items.filter { it.field4 }
            .map { it.copy(field2 = it.field1.uppercase(), field3 = it.field3 + 1) }
            .sortedBy { it.field3 }
    }
    fun transform(items: List<Entity603>): Map<String, List<Entity603>> {
        return items.groupBy { it.field1 }
            .mapValues { (_, v) -> v.sortedByDescending { it.field8 } }
    }
    fun validate(entity: Entity603): Boolean {
        return entity.field1.isNotBlank() && entity.field3 >= 0 && entity.field6 > 0.0
    }
}

@RestController
@RequestMapping("/api/v1/entity603")
class Controller603(private val service: Service603) {
    @GetMapping
    fun getAll() = service.findAll()
    @GetMapping("/search")
    fun search(@RequestParam q: String) = service.search(q)
    @GetMapping("/active")
    fun getActive() = service.findActive()
    @PostMapping
    fun create(@RequestBody entity: Entity603) = service.save(entity)
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
