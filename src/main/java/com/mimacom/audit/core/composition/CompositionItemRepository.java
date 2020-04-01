package com.mimacom.audit.core.composition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionItemRepository extends JpaRepository<CompositionItem, String> {
}