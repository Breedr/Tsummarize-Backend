package uk.breedrapps.tsummarizebackend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uk.breedrapps.tsummarizebackend.model.Tsum
import uk.breedrapps.tsummarizebackend.repository.TsumRepository
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class TsumController(private val tsumRepository: TsumRepository) {

    @GetMapping("/tsum")
    fun getAllTsums(): List<Tsum> = tsumRepository.findAll()


    @PostMapping("/tsum")
    fun createNewTsum(@Valid @RequestBody tsum: Tsum): Tsum = tsumRepository.save(tsum)


    @GetMapping("/tsum/{id}")
    fun getTsumById(@PathVariable(value = "id") tsumId: Long): ResponseEntity<Tsum> {
        return tsumRepository.findById(tsumId).map { tsum ->
            ResponseEntity.ok(tsum)
        }.orElse(ResponseEntity.notFound().build())
    }

}