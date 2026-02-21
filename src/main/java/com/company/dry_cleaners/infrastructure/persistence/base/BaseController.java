package com.company.dry_cleaners.infrastructure.persistence.base;

public abstract class BaseController<T, ID> {
	/*
	 * protected final BaseService<T, ID> service;
	 * 
	 * protected BaseController(BaseService<T, ID> service) { this.service =
	 * service; }
	 * 
	 * @GetMapping public ResponseEntity<List<T>> findAll() { return
	 * ResponseEntity.ok(service.findAll()); }
	 * 
	 * @GetMapping("/{id}") public ResponseEntity<T> findById(@PathVariable ID id) {
	 * return service.findById(id) .map(ResponseEntity::ok)
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping public ResponseEntity<T> create(@RequestBody T entity) { return
	 * ResponseEntity.ok(service.save(entity)); }
	 * 
	 * @PutMapping("/{id}") public ResponseEntity<T> update(@PathVariable ID id,
	 * 
	 * @RequestBody T entity) { return ResponseEntity.ok(service.update(id,
	 * entity)); }
	 * 
	 * @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable ID
	 * id) { service.delete(id); return ResponseEntity.noContent().build(); }
	 */
}