package com.company.dry_cleaners.shared.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public record PageQuery(int page, int size) {
	
	public Pageable toPageable() {
		return PageRequest.of(page, size, Sort.by("id").descending());
	}
	
}