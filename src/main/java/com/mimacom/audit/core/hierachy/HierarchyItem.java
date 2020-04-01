package com.mimacom.audit.core.hierachy;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Entity
public class HierarchyItem extends Audit {

    @Id
    String id = UUID.randomUUID().toString();

    String value;

    public HierarchyItem(String value) {
        this.value = value;
    }
}