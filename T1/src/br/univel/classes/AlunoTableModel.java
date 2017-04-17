package br.univel.Classes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.annotations.Coluna;
import br.univel.annotations.Tabela;

public class AlunoTableModel extends AbstractTableModel {

	private List<Aluno> dados;
    private String[] colunas = {"Id" , "Nome"};
	
    public AlunoTableModel(){
        dados = new ArrayList<Aluno>();
    }
    
    public void addRow(Aluno a){
        this.dados.add(a);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public String getColumnName(int num){
        return this.colunas[num];
    }
    
	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch(column){
        case 0: return dados.get(row).getId();
        case 1: return dados.get(row).getNome();
		}   
    return null;
	}

}

