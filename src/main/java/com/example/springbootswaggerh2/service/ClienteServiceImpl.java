package com.example.springbootswaggerh2.service;

import com.example.springbootswaggerh2.exception.ResourceNotFoundException;
import com.example.springbootswaggerh2.model.Cliente;
import com.example.springbootswaggerh2.model.Employee;
import com.example.springbootswaggerh2.repository.ClienteRepository;
import com.example.springbootswaggerh2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
    ClienteRepository repository;

	@Override
	public Cliente createCliente(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente getClienteById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employees", "id", "employeeId"));
	}

	@Override
	public List<Cliente> getClientes() {
		return repository.findAll();
	}

	@Override
	public Cliente updateClienteById(Long id, Cliente cliente) {
        Cliente clienteDetail = this.getClienteById(id);
        clienteDetail.setNombre(cliente.getNombre());
        clienteDetail.setApellidoPaterno(cliente.getApellidoPaterno());
        clienteDetail.setApellidoMaterno(cliente.getApellidoMaterno());
        clienteDetail.setFechaCreacion(new Date());
        clienteDetail.setEstado(true);
		return repository.save(clienteDetail);
	}

	@Override
	public void deleteClienteById(Long id) {
		Cliente cliente = this.getClienteById(id);
		repository.delete(cliente);
	}

}
