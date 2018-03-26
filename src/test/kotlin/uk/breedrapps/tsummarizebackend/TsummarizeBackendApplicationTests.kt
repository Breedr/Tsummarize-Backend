package uk.breedrapps.tsummarizebackend

import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import uk.breedrapps.tsummarizebackend.controller.TsumController
import uk.breedrapps.tsummarizebackend.model.Tsum
import java.util.Collections.singletonList


@RunWith(SpringRunner::class)
@WebMvcTest(TsumController::class)
class TsummarizeBackendApplicationTests {

    @Value("\${tsummarize.http.auth-token-header}")
    lateinit var principalRequestHeader: String

    @Value("\${tsummarize.http.auth-token}")
    lateinit var principalRequestValue: String

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var tsumController: TsumController

    lateinit var tsum: Tsum

    @Before
    fun before() {
        tsum = Tsum(
                1,
                "Test Tsum",
                "Test Description",
                "http://example.com/image.jpg"
        )
    }

    @Test
    fun `load tsum list endpoint` () {

        val tsumList = singletonList(tsum)

        given(tsumController.getAllTsums()).willReturn(tsumList)

        mockMvc.perform(
                get("/api/tsum").header(principalRequestHeader, principalRequestValue))
                .andExpect(status().isOk)
    }

    @Test
    fun `load tsum by id endpoint` () {

        given(tsumController.getTsumById(tsum.id)).willReturn(ResponseEntity.ok(tsum))

        mockMvc.perform(get("/api/tsum/{id}", tsum.id).header(principalRequestHeader, principalRequestValue))
                .andExpect(status().isOk)
                .andExpect(jsonPath("id", isLong(tsum.id)))

    }

    private fun isLong(value: Long): Matcher<Int> {
        return org.hamcrest.core.Is.`is`(value.toInt())
    }

}
