package com.example.SistemaPala.exception;

import com.example.SistemaPala.api.dto.ApiResponse;
import java.time.Instant;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiResponse<Object>> handleBusinessException(BusinessException exception, HttpServletRequest request) {
		log.warn("Business error on {}: {}", request.getRequestURI(), exception.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ApiResponse.error(exception.getMessage(), new ErrorPayload(exception.getCode(), request.getRequestURI())));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Object>> handleUnexpectedException(Exception exception, HttpServletRequest request) {
		log.error("Unexpected error on {}", request.getRequestURI(), exception);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ApiResponse.error("Error interno del sistema", new ErrorPayload("INTERNAL_ERROR", request.getRequestURI())));
	}

	private record ErrorPayload(String code, String path, Instant timestamp) {
		private ErrorPayload(String code, String path) {
			this(code, path, Instant.now());
		}
	}
}
