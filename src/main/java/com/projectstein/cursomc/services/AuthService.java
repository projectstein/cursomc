package com.projectstein.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectstein.cursomc.domain.Cliente;
import com.projectstein.cursomc.repository.ClienteRepository;
import com.projectstein.cursomc.services.exception.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random(); 
	
	
	public void sendNewPassword(String email){
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundException("Email não foi encontrado");
		}
		
		String newPass = newPassWord();
		cliente.setSenha(pe.encode(newPass));
		clienteRepository.save(cliente); 
		emailService.sendNewPasswordEmail(cliente, newPass);
	}


	private String newPassWord() {
		char[] vet = new char[10];
		for(int i = 0;i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}


	private char randomChar() {
		int opt =rand.nextInt(3);
		if(opt == 0) {
			return (char)(rand.nextInt(10)+48);
		}
		else if(opt ==1){
			return (char)(rand.nextInt(26)+65);
		}else {
			return (char)(rand.nextInt(26)+97);
		}
	}
	

}
