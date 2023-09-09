package br.com.erudio.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*
import kotlin.Exception

@ControllerAdvice
@RestController
class CustomizedResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(
        exception: Exception,
        request: WebRequest
    ): ResponseEntity<ExceptionResponde> {
        val exceptionResponde = ExceptionResponde(
            timestamp = Date(),
            message = exception.message,
            details = request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponde>(
            exceptionResponde,
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }

    @ExceptionHandler(UnsupportedNameParamsException::class)
    fun handleUnsupportedNameException(
        exception: Exception,
        request: WebRequest
    ): ResponseEntity<ExceptionResponde> {
        val exceptionResponde = ExceptionResponde(
            timestamp = Date(),
            message = exception.message,
            details = request.getDescription(false)
        )
        return ResponseEntity<ExceptionResponde>(
            exceptionResponde,
            HttpStatus.BAD_REQUEST
        )
    }
}