package com.app.leave_manager.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leave_types", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@FilterDef(name = "deletedLeaveTypeFilter", parameters = @ParamDef(name = "isDeleted", type = boolean.class))
@Filter(name = "deletedLeaveTypeFilter", condition = "deleted = :isDeleted")
@SQLDelete(sql = "UPDATE leave_types SET deleted = true, unique_field_nonce = CURRENT_TIMESTAMP WHERE id = ? and version = ?")
public class LeaveType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leave_type_seq")
    @SequenceGenerator(name = "leave_type_seq", sequenceName = "leave_type_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer defaultDays;

    @Builder.Default
    @OneToMany(mappedBy = "leaveType", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LeaveBalance> leaveBalances = new HashSet<>();
}
