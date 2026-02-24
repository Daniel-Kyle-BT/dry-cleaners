package com.company.dry_cleaners.infrastructure.persistence.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.company.dry_cleaners.domain.repository.BaseRepository;

public abstract class BaseRepositoryImpl<E, ID, J extends JpaRepository<E, ID>> 
	implements BaseRepository<E, ID> {

	protected final J jpa;

	protected BaseRepositoryImpl(J jpa) {
		this.jpa = jpa;
	}

    @Override
    public E save(E entity) {
        return jpa.save(entity);
    }

    @Override
    public Optional<E> findById(ID id) {
        return jpa.findById(id);
    }

	@Override
	public Page<E> findAll(Pageable pageable) {
		return jpa.findAll(pageable);
	}

	@Override
	public boolean existsById(ID id) {
		return jpa.existsById(id);
	}

    @Override
    public void delete(E entity) {
        jpa.delete(entity);
    }
    
    @Override
    public long count() {
        return jpa.count();
    }

    @Override
    public List<E> saveAll(List<E> entities) {
        return jpa.saveAll(entities);
    }
}
