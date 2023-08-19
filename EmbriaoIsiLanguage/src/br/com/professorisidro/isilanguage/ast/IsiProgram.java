package br.com.professorisidro.isilanguage.ast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;

public class IsiProgram {
	private IsiSymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String progamName;
	
	public void generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public calss MainClass{\n");
		str.append("	public static vois main (String args[]) {\n");
		str.append("		Scanner _key = new Scanner(System.in);\n");
		for (IsiSymbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode()+"\n");
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode()+"\n");
		}
		str.append("	}\n");
		str.append("}\n");
		
		try {
			FileWriter fr = new FileWriter(new File("MainClass.java"));
			fr.write(str.toString());
			fr.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public IsiSymbolTable getVartable() {
		return varTable;
	}



	public void setVarTable(IsiSymbolTable varTable) {
		this.varTable = varTable;
	}



	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}



	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}



	public String getProgamName() {
		return progamName;
	}



	public void setProgamName(String progamName) {
		this.progamName = progamName;
	}

}
