package com.app.leave_manager.reponse;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseUtils {
    private ResponseUtils() {
        // Prevent instantiation
    }

    public static <T> ResponseEntity<ApiResponse<T>> buildResponse(HttpStatus httpStatus, String message) {
        return ResponseBuilder.buildResponseEntity(httpStatus, null, message);
    }

    public static <T> ResponseEntity<ApiResponse<T>> buildResponse(HttpStatus httpStatus, T data, String message) {
        return ResponseBuilder.buildResponseEntity(httpStatus, data, message);
    }

    public static <T> ResponseEntity<Paginated<T>> buildPaginatedResponse(Page<T> page, String message) {
        return ResponseBuilder.buildPaginatedResponseEntity(page, message);
    }

}
