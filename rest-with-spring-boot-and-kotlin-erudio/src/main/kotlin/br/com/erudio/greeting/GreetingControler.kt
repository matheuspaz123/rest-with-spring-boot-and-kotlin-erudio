package br.com.erudio.greeting

import br.com.erudio.exceptions.UnsupportedNameParamsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingControler {

    @Autowired
    lateinit var service: GreetingService

    @RequestMapping(
        value = [ENDPOINT_GREETING],
        method = [RequestMethod.GET],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun greeting(
        @RequestParam name: String?
    ) = service.getGreeting(name)
    companion object {
        private const val ENDPOINT_GREETING = "/greeting"
    }
}