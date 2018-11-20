package services;


//Classe criada pra evitar a sobrecarga de fun��es da classe Trello

public class Listador {
	
	Trello listador = new Trello();
	
	
	public Listador(Trello trello) {
		this.listador = trello;
	}
	
	public String menu1() {
		return "Bem-Vindo ao Trello Simulator!\n1-> Adicionar Quadro\n2-> Acessar Quadro\n3-> Listar Quadros\n0-> Sair";
	}
	
	public String menu2(String nomeQ) {
		return "Voc� Est� no quadro " + nomeQ + "n\n1-> Adicionar Lista\n2-> Listar listas\n3->Adicionar Cart�o h� uma lista\n5->Acessar Cart�o \n4-> Arquivar/Restaurar Lista"
				+ "\n5-> Arquivar todos os cart�es desta Lista\n->6 Alterar Privacidae\n7-> Favoritar/Desfavoritar\n8-> Remover Lista\n0-> Sair";
	}
	
	public String menu3(String card,String lista) {
		return "Cart�o " + card + " na lista " + lista + "\n1-> Adicionar Etiqueta\n2-> Criar uma Descri��o\n"
				+ "3->Adicionar Coment�rio\n4-> Registro de atividades\n->5 Arquivar/Restaurar Cart�o\n Remover Cart�o\n->0 Sair"; 
		
	}
	
	
	public String listarQuadros(){
		String quadros = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.quadros.size();i++){
				quadros = quadros + "Quadro-> " + this.listador.quadros.get(i).nome + " Possui" + 
				this.listador.quadros.get(i).listas.size() + " listas" + "\n";
			}
		}
		else{
			quadros = "Voc� n�o possui quadros";
		}
		
		return quadros;
			
		}
	
	
	public String listarListas(String nomeDoQuadro){
		String lists = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.acessaQuadro(nomeDoQuadro).listas.size();i++){
				lists = lists + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + " Possui" + 
				this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).cartoes.size() + " Cart�es" + "\n";
			}
		}
		else{
			lists = "Voc� n�o possui listas";
		}
		
		return lists;
			
		}
	

	public String listarCartoes(String nomeQ,String nomeDaLista){
		String cards = "";
		if(!this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.isEmpty()){
			for(int i = 0; i < this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.size();i++){
				cards = cards + "Cart�o-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui" + 
				this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui" + 
				this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "coment�rios \n";
			}
		}
		else{
			cards = "Voc� n�o possui listas";
		}
		
		return cards;
			
		}
	
	public String registroAtividade(String card,String nomeDaLista,String nomeQ) {
		String log = "";
		if(!this.listador.acessarCartao(card,nomeDaLista,nomeQ).log.isEmpty()){
			for(int i = 0; i < this.listador.acessarCartao(card,nomeDaLista,nomeQ).log.size();i++){
				log = log + this.listador.acessarCartao(card, nomeDaLista, nomeQ).log.get(i) + "\n";
			}
		}
		else{
			log = "Ainda n�o h� registros";
		}
		
		return log;
	}

}
