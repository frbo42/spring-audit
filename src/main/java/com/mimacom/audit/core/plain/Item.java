package com.mimacom.audit.core.plain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Item {
    @Id
    String id = UUID.randomUUID().toString();

    @CreatedBy
    String createdBy;

    @LastModifiedBy
    String lastModifiedBy;

    @CreatedDate
    ZonedDateTime createdDate;

    @LastModifiedDate
    ZonedDateTime lastModifiedDate;

    String value;

    public Item(String value) {
        this.value = value;
    }
}
