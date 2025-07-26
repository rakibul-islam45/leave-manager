package com.app.leave_manager.model.entities;

import com.app.leave_manager.model.constant.DbConstants;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Version
    private Long version;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    @Builder.Default
    @Column(nullable = false)
    @ColumnDefault("true")
    private Boolean active = true;

    @Builder.Default
    @Column(nullable = false)
    @ColumnDefault("false")
    private Boolean deleted = false;

    @Builder.Default
    @Column(nullable = false)
    @ColumnDefault("'1900-01-01 00:00:00'")
    private Instant uniqueFieldNonce = DbConstants.UNIQUE_FIELD_NONCE;
}
