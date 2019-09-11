package com.yuzosergio.Cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yuzosergio.Cursomc.domain.Categoria;
import com.yuzosergio.Cursomc.domain.Cidade;
import com.yuzosergio.Cursomc.domain.Cliente;
import com.yuzosergio.Cursomc.domain.Endereco;
import com.yuzosergio.Cursomc.domain.Estado;
import com.yuzosergio.Cursomc.domain.ItemPedido;
import com.yuzosergio.Cursomc.domain.Pagamento;
import com.yuzosergio.Cursomc.domain.PagamentoComBoleto;
import com.yuzosergio.Cursomc.domain.PagamentoComCartao;
import com.yuzosergio.Cursomc.domain.Pedido;
import com.yuzosergio.Cursomc.domain.Produto;
import com.yuzosergio.Cursomc.domain.enums.EstadoPagamento;
import com.yuzosergio.Cursomc.domain.enums.TipoCliente;
import com.yuzosergio.Cursomc.repositories.CategoriaRepository;
import com.yuzosergio.Cursomc.repositories.CidadeRepository;
import com.yuzosergio.Cursomc.repositories.ClienteRepository;
import com.yuzosergio.Cursomc.repositories.EnderecoRepository;
import com.yuzosergio.Cursomc.repositories.EstadoRepository;
import com.yuzosergio.Cursomc.repositories.ItemPedidoRepository;
import com.yuzosergio.Cursomc.repositories.PagamentoRepository;
import com.yuzosergio.Cursomc.repositories.PedidoRepository;
import com.yuzosergio.Cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		Produto	p1= new Produto(null, "Computador", 2000.00);
		Produto	p2= new Produto(null, "Impressora", 800.00);
		Produto	p3= new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriarepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente	cli1 = new Cliente(null, "Maria Silva","maria1@gmail.com","15615641655",TipoCliente.PESSOAFISICA);
		 
		cli1.getTelefones().addAll(Arrays.asList("54562328","56262646"));
		
		Endereco e1 = new Endereco(null,"Rua Flores" , "150","apto 300" , "Jardim","652568945",cli1,c1);
		Endereco e2 = new Endereco(null,"Avenida Maria" , "154","apto 307" , "Centro","84984561",cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:22"), cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:22"), cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,2000.00);
		ItemPedido ip2 = new ItemPedido(ped1,p3,0.00,2,80.00);
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	}

}
