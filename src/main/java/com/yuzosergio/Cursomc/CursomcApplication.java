package com.yuzosergio.Cursomc;

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
import com.yuzosergio.Cursomc.domain.Produto;
import com.yuzosergio.Cursomc.domain.enums.TipoCliente;
import com.yuzosergio.Cursomc.repositories.CategoriaRepository;
import com.yuzosergio.Cursomc.repositories.CidadeRepository;
import com.yuzosergio.Cursomc.repositories.ClienteRepository;
import com.yuzosergio.Cursomc.repositories.EnderecoRepository;
import com.yuzosergio.Cursomc.repositories.EstadoRepository;
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
		
	}

}
