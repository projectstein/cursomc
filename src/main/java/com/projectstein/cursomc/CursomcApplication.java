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
import com.projectstein.cursomc.domain.PagamentoBoleto;
import com.projectstein.cursomc.domain.PagamentoCartao;
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

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository; 
	@Autowired
	private PedidoRepository pedidoRepository; 
	@Autowired
	private PagamentoRepository pagamentoRepository; 
	@Autowired
	private ItemPedidoRepository itemPedidoRepository; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática" );
		Categoria cat2 = new Categoria(null, "Escritório" );
		
		Produto p1 = new Produto(null, "Computador", 2000.00 );
		Produto p2 = new Produto(null, "Impressora", 800.00 );
		Produto p3 = new Produto(null, "Mouse", 80.00 );
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "Sao Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1= new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834",cli1,c1);
		Endereco e2= new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38220834",cli1,c2);
	
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cli1, e2);
		
		Pagamento pagto1= new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2= new PagamentoBoleto(null, EstadoPagamento.PENDENTE , ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 2000.00, 1);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 80.00, 2);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 800.00, 1);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		pedidoRepository.save(Arrays.asList(ped1,ped2));
		pagamentoRepository.save(Arrays.asList(pagto1,pagto2));
		itemPedidoRepository.save(Arrays.asList(ip1,ip2,ip3));
		
	}
	
}
