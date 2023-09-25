package com.materias.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.materias.service.MateriasService;
import com.persistence_escuela.entity.Materias;
import com.persistence_escuela.repository.MateriasRepository;
import com.persistence_escuela.request.MateriasRequest;

@Service
public class MateriasImplement implements MateriasService{

	@Autowired
	MateriasRepository repo;

	@Override
	public Materias guardar(MateriasRequest request) {
		Materias m = new Materias();
		m.setMateria(request.getMateria());
		repo.save(m);
		return m;
	}

	@Override
	public Materias actualizar(MateriasRequest request) {
		Materias m = repo.findById(request.getIdMateria()).get();
		m.setMateria(request.getMateria());
		repo.save(m);
		return m;
	}

	@Override
	public Materias buscar(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Materias buscar(String name) {
		
		return repo.findByNombre(name).get();
	}

	@Override
	public String eliminar(int id) {
		repo.deleteById(id);
		return "Borrado";
	}

	@Override
	public List<Materias> mostrar() {
		
		return repo.findAll();
	}

}
