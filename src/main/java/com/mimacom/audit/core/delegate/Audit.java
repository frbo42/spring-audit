package com.mimacom.audit.core.delegate;

import lombok.Getter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Embeddable;
import java.time.ZonedDateTime;

@Getter

@AccessType(AccessType.Type.FIELD)
@Embeddable
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