package br.com.erudio.greeting

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingControler {

    private val id = AtomicLong()

    @RequestMapping("/greeting")
    fun greeting(
        @RequestParam name: String?
    ) = GreetingModel(
        id = id.incrementAndGet(),
        content = "Hello ${name.orWorld()}!"
    )

    fun String?.orWorld() = if(this.isNullOrBlank()) "World" else this
}