package examenud5.ejercicio1;

import java.util.Comparator;

public class ComparadorHoras implements Comparator<Curso> {

	@Override
	public int compare(Curso c1, Curso c2) {
		int resultado=0;
		
		if (c1.getHoras()>c2.getHoras())
			resultado=-1;
		else if (c2.getHoras()<c2.getHoras())
			resultado=1;
		
		
		return resultado;
	}

}
