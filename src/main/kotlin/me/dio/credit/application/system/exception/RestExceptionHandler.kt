package me.dio.credit.application.system.exception

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.time.LocalDate
import java.time.LocalDateTime

@RestControllerAdvice
class RestExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerValidException(ex: MethodArgumentNotValidException) : ResponseEntity<ExceptionDetails> {
        val erros: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.stream().forEach{
            erro: ObjectError ->
            val fieldName: String = (erro as FieldError).field
            val messageError: String? = erro.defaultMessage
            erros[fieldName] = messageError
        }
        return ResponseEntity(
                ExceptionDetails(
                title = "Bad Request! Consult the documentation",
                timestamp = LocalDateTime.now(),
                status = HttpStatus.BAD_REQUEST.value(),
                exception = ex.objectName,
                details = erros

                ), HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(BusinessException::class)
    fun handlerValidException(ex: BusinessException) : ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ExceptionDetails(
                                title = "Bad Request! Consult the documentation",
                                timestamp = LocalDateTime.now(),
                                status = HttpStatus.BAD_REQUEST.value(),
                                exception = ex.javaClass.toString(),
                                details = mutableMapOf(ex.cause.toString() to ex.message)
                        )
                )
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handlerValidException(ex: DataIntegrityViolationException) : ResponseEntity<ExceptionDetails> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ExceptionDetails(
                                title = "Bad Request! Integridade de chave",
                                timestamp = LocalDateTime.now(),
                                status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                exception = ex.javaClass.toString(),
                                details = mutableMapOf(ex.cause.toString() to ex.message)
                        )
                )
    }
}