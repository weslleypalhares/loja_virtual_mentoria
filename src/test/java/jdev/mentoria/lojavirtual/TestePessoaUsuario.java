package jdev.mentoria.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import jdev.mentoria.lojavirtual.controller.PessoaController;
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
		pessoaJuridica.setEmail("Walex.fernando.egidio@gamil.com");
		pessoaJuridica.setTelefone("2245999795800");
		pessoaJuridica.setInscEstadual("2264464654654645");
		pessoaJuridica.setInscMunicipal("2264464654654645");
		pessoaJuridica.setNomeFantasia("2jdveeeeee");
		pessoaJuridica.setRazaoSocial("2camelo");
		
		pessoaController.salvarPj(pessoaJuridica);
		
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
