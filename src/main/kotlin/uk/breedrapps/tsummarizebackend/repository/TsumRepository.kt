package uk.breedrapps.tsummarizebackend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import uk.breedrapps.tsummarizebackend.model.Tsum

@Repository
interface TsumRepository : JpaRepository<Tsum, Long>