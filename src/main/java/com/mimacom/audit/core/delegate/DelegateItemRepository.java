package com.mimacom.audit.core.delegate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DelegateItemRepository extends JpaRepository<DelItem, String> {
}