package br.com.erudio.greeting

import br.com.erudio.exceptions.UnsupportedNameParamsException
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class GreetingService {
    val id = AtomicLong()

    fun getGreeting(name: String?) =  if (name.isNullOrBlank())
        throw UnsupportedNameParamsException(UNSUPPORTED_NAME_ERROR_MSG)
    else
        GreetingModel(
            id = id.incrementAndGet(),
            content = "Hello $name!"
        )

    companion object {
        private const val UNSUPPORTED_NAME_ERROR_MSG = "Add a name param to request body"
    }
}