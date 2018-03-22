package uk.breedrapps.tsummarizebackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TsummarizeBackendApplication

fun main(args: Array<String>) {
    runApplication<TsummarizeBackendApplication>(*args)
}
