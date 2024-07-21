package jdev.mentoria.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import jdev.mentoria.lojavirtual.controller.PessoaController;
import jdev.mentoria.lojavirtual.enums.TipoEndereco;
import jdev.mentoria.lojavirtual.model.Endereco;
import jdev.mentoria.lojavirtual.model.PessoaJuridica;
import junit.framework.TestCase;

@Profile("test")
@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class TestePessoaUsuario extends TestCase {

	
	@Autowired
	private PessoaController pessoaController;
	
	@Test
	public void testCadPessoaFisica() throws ExceptionMentoriaJava {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
		pessoaJuridica.setNome("WAlex fernando");
		pessoaJuridica.setEmail("wesdsfsfx.fernando.egidio@gamil.com");
		pessoaJuridica.setTelefone("2245999795800");
		pessoaJuridica.setInscEstadual("2264464654654645");
		pessoaJuridica.setInscMunicipal("2264464654654645");
		pessoaJuridica.setNomeFantasia("2jdveeeeee");
		pessoaJuridica.setRazaoSocial("2camelo");
		
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("Jd dias");
		endereco1.setCep("4654646");
		endereco1.setComplemento("Casa Cinza");
		endereco1.setEmpresa(pessoaJuridica);
		endereco1.setNumero("45");
		endereco1.setPessoa(pessoaJuridica);
		endereco1.setRuaLogra("Av. João Sexto");
		endereco1.setTipoEndereco(TipoEndereco.COBRANCA);
		endereco1.setUf("PR");
		endereco1.setCidade("maringa");
		
		
		Endereco endereco2 = new Endereco();
		endereco2.setBairro("Rua MAcauba");
		endereco2.setCep("79794");
		endereco2.setComplemento("AApto");
		endereco2.setEmpresa(pessoaJuridica);
		endereco2.setNumero("6484");
		endereco2.setPessoa(pessoaJuridica);
		endereco2.setRuaLogra("Rua Direita");
		endereco2.setTipoEndereco(TipoEndereco.ENTREGA);
		endereco2.setUf("MA");
		endereco2.setCidade("Maranhão");
		
		
		pessoaJuridica.getEnderecos().add(endereco2);
		pessoaJuridica.getEnderecos().add(endereco1);
	
		
		pessoaJuridica = pessoaController.salvarPj(pessoaJuridica).getBody();
		
		assertEquals(true, pessoaJuridica.getId() > 0);
		
		for (Endereco endereco : pessoaJuridica.getEnderecos()) {
			assertEquals(true, endereco.getId() > 0);
		}
		
		assertEquals(2, pessoaJuridica.getEnderecos().size());
		
		
		/*
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setCpf("0597975788");
		pessoaFisica.setNome("Alex fernando");
		pessoaFisica.setEmail("alex.fernando.egidio@gamil.com");
		pessoaFisica.setTelefone("45999795800");
		pessoaFisica.setEmpresa(pessoaFisica);
		*/
	}
	
}
