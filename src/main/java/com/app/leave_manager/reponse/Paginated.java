package com.app.leave_manager.reponse;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Getter
@SuperBuilder
final public class Paginated<T> extends BaseResponse {
    private Integer size;
    private Integer page;
    private Integer totalPages;
    private Long totalRecords;
    private Collection<T> data;
}