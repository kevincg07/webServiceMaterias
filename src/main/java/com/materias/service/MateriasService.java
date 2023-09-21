package com.materias.service;

import java.util.List;

import com.persistence_escuela.entity.Materias;
import com.persistence_escuela.request.MateriasRequest;

public interface MateriasService {
	
	Materias guardar(MateriasRequest request);
	Materias actualizar(MateriasRequest request);
	Materias buscar(int id);
	Materias buscar(String name);
	String eliminar(int id);
	List<Materias> mostrar();

}
