package com.app.leave_manager.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder(toBuilder = true)
public abstract class BaseResponse {
    private boolean success;
    private String message;
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
