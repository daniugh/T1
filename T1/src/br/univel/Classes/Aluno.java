package br.univel.Classes;

import br.univel.annotations.Coluna;
import br.univel.annotations.Tabela;

@Tabela("aluno")
public class Aluno {
	
	@Coluna(name = "Nome")
	private String nome;
	
	@Coluna(name = "Ra")
	private int ra;
	
    public Aluno(String nome, int ra) {
    	this.nome = nome;
    	this.ra = ra;
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
