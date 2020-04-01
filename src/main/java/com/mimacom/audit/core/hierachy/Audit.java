package com.mimacom.audit.core.hierachy;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public class Audit {
    @CreatedBy
    String createdBy;

    @LastModifiedBy
    String lastModifiedBy;

    @CreatedDate
    ZonedDateTime createdDate;

    @LastModifiedDate
    ZonedDateTime lastModifiedDate;
}