package jdev.mentoria.lojavirtual;

import jdev.mentoria.lojavirtual.util.ValidaCNPJ;
import jdev.mentoria.lojavirtual.util.ValidaCPF;

public class TesteCPFCNPJ {

	
	public static void main(String[] args) {
		boolean isCnpj = ValidaCNPJ.isCNPJ("40.777.038/0001-90");
		
		System.out.println("Cnpj Válido: " + isCnpj);
		
		
		boolean isCPF = ValidaCPF.isCPF("357.882.820-39");
		
		System.out.println("Cpf Válido: " + isCPF);
	}
}
