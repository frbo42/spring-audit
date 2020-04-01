package com.mimacom.audit.core.delegate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
@EntityListeners(AuditingEntityListener.class)
public class DelItem {

    @Id
    String id = UUID.randomUUID().toString();

    @Embedded
    Audit audit = new Audit();

    String value;

    public DelItem(String value) {
        this.value = value;
    }
}