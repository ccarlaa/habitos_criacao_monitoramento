package controle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ControleHabitos {
	public String[] getHabitosMensuraveis(ControleDados dados, int usuarioId) {
		int qtdHabitos = 0;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i].getId() == usuarioId) {
				qtdHabitos++;
			}
		}
		
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("EEEEE");
		String dia = df.format(date);
		String[] habitos = new String[qtdHabitos];
		int tamanhoLista = 0;
		for(int i = 0; i < dados.qtdHabitosMensuraveis(); i++) {
			if(dados.getHabitosMensuraveis()[i].getId() == usuarioId ) {
				List<String> lista = Arrays.asList(dados.getHabitosMensuraveis()[i].getDias());
				if(lista.contains(dia)) {
					habitos[tamanhoLista] = dados.getHabitosMensuraveis()[i].getNome();
					tamanhoLista++;
				}
			}
		}
		
		return habitos;
	}
}
