package com.mimacom.audit.core.composition;

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
public class CompositionItem {

    @Id
    String id = UUID.randomUUID().toString();

    @Embedded
    Audit audit = new Audit();

    String value;

    public CompositionItem(String value) {
        this.value = value;
    }
}