package com.app.leave_manager.reponse;


import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final  class ResponseBuilder {
    private ResponseBuilder() {
    }

    static <T> ResponseEntity<ApiResponse<T>> buildResponseEntity(HttpStatus httpStatus, @Nullable T data, String message) {
        ApiResponse<T> success = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
        return ResponseEntity.status(httpStatus.value()).body(success);
    }

    static <T> ResponseEntity<Paginated<T>> buildPaginatedResponseEntity(Page<T> page, String message) {
        Paginated<T> paginated = Paginated.<T>builder()
                .success(true)
                .message(message)
                .page(page.getPageable().getPageNumber())
                .size(page.getSize())
                .totalPages(page.getTotalPages())
                .totalRecords(page.getTotalElements())
                .data(page.getContent())
                .build();
        return ResponseEntity.status(HttpStatus.OK.value()).body(paginated);
    }
}
