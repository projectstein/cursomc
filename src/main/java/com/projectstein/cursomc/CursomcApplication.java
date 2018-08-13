package com.projectstein.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projectstein.cursomc.domain.Categoria;
import com.projectstein.cursomc.domain.Cidade;
import com.projectstein.cursomc.domain.Cliente;
import com.projectstein.cursomc.domain.Endereco;
import com.projectstein.cursomc.domain.Estado;
import com.projectstein.cursomc.domain.ItemPedido;
import com.projectstein.cursomc.domain.Pagamento;
import com.projectstein.cursomc.domain.PagamentoComBoleto;
import com.projectstein.cursomc.domain.PagamentoComCartao;
import com.projectstein.cursomc.domain.Pedido;
import com.projectstein.cursomc.domain.Produto;
import com.projectstein.cursomc.domain.enums.EstadoPagamento;
import com.projectstein.cursomc.domain.enums.TipoCliente;
import com.projectstein.cursomc.repository.CategoriaRepository;
import com.projectstein.cursomc.repository.CidadeRepository;
import com.projectstein.cursomc.repository.ClienteRepository;
import com.projectstein.cursomc.repository.EnderecoRepository;
import com.projectstein.cursomc.repository.EstadoRepository;
import com.projectstein.cursomc.repository.ItemPedidoRepository;
import com.projectstein.cursomc.repository.PagamentoRepository;
import com.projectstein.cursomc.repository.PedidoRepository;
import com.projectstein.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}
	
}
