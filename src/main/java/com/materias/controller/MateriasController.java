package com.materias.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.materias.impl.MateriasImplement;
import com.persistence_escuela.entity.Materias;
import com.persistence_escuela.request.MateriasRequest;

@RestController
@RequestMapping("materias/")
public class MateriasController {

	@Autowired
	MateriasImplement logic;
	
	@PostMapping
	ResponseEntity<Materias> guardar(@Valid @RequestBody MateriasRequest request){
		Materias m = logic.guardar(request);
		return new ResponseEntity<Materias>(m, HttpStatus.OK);
	}
	
	@PutMapping
	ResponseEntity<Materias> actualizar(@RequestBody MateriasRequest request){
		Materias m = logic.actualizar(request);
		return new ResponseEntity<Materias>(m, HttpStatus.OK);
	}
	
	@DeleteMapping("borrar-por-id/{id}")
	ResponseEntity<String> borrar(@PathVariable("id") int id){
		String m = logic.eliminar(id);
		return new ResponseEntity<String>(m, HttpStatus.OK);
	}
	
	@GetMapping("buscar-por-id/{id}")
	ResponseEntity<Materias> buscar(@PathVariable("id") int id){
		Materias m = logic.buscar(id);
		return new ResponseEntity<Materias>(m, HttpStatus.OK);
		
	}
	
	@GetMapping("buscar/por/nombre/{name}")
	ResponseEntity<Materias> buscar(@PathVariable("name")String name){
		Materias m = logic.buscar(name);
		return new ResponseEntity<Materias>(m, HttpStatus.OK);
	}
	
	@GetMapping
	ResponseEntity<List<Materias>> mostrar(){
		List<Materias> materias = logic.mostrar();
		return new ResponseEntity<List<Materias>>(materias, HttpStatus.OK);
	}
	
}
