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
		return "Voc� est� no quadro " + nomeQ + "\n1-> Alterar Privacidade\n2-> Favoritar/Desfavoritar\n3-> Adicionar Lista"
				+ "\n4-> Acessar Lista\n5-> Arquivar/Restaurar lista\n6-> Mover Lista\n7-> Copiar Lista\n8-> Remover Lista\n0-> Sair";
	}
	
	public String menu3(String nomeLista) {
		return "A��es da lista " + nomeLista + "\n1-> Adicionar Cart�o\n2->Acessar Cart�o\n3-> Mover todos os cart�es desta lista\n4-> Arquivar todos os cart�es desta lista\n->0 Sair";
		
	}
	
	public String menu3(String card,String lista) {
		return "Cart�o " + card + " na lista " + lista + "\n1-> Adicionar Etiqueta\n2-> Criar uma Descri��o\n"
				+ "3->Adicionar Coment�rio\n4-> Registro de atividades\n5-> Arquivar/Restaurar Cart�o\n6-> Mover Cart�o\n7-> remover cart�o\n->0 Sair"; 
		
	}
	
	
	public String listarQuadros(){
		String quadros = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.quadros.size();i++){
				quadros = quadros + "Quadro-> " + this.listador.quadros.get(i).nome + " Possui " + 
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
		String listsArq = "";
		if(!this.listador.quadros.isEmpty()){
			for(int i = 0; i < this.listador.acessaQuadro(nomeDoQuadro).listas.size();i++){
				if(this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).arquivado == false)
					lists = lists + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + "\n";
				
				else if(this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).arquivado == true)
					listsArq = listsArq + "Lista-> " + this.listador.acessaQuadro(nomeDoQuadro).listas.get(i).nome + "\n";
			}
		}
		else{
			lists = "Voc� n�o possui listas";
			listsArq = "Ainda n�o h� listas arquivadas";
		}
		
		return "*---Listas---*\n" + lists + "\n*---Listas Arquivadas---*\n" + listsArq;
			
		}
	

	public String listarCartoes(String nomeQ,String nomeDaLista){
		String cards = "";
		String cardArq = "";
		if(!this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.isEmpty()){
			for(int i = 0; i < this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.size();i++){
				if(this.listador.acessaLista(nomeDaLista, nomeQ).cartoes.get(i).arquivado == false)
					cards = cards + "Cart�o-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "coment�rios \n";
				
				else if(this.listador.acessaLista(nomeDaLista, nomeQ).cartoes.get(i).arquivado == true) {
					cardArq = cardArq + "Cart�o-> " + this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).nome + " " + " possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).etiquetas.size() + " Etiquetas e possui " + 
					this.listador.acessaLista(nomeDaLista,nomeQ).cartoes.get(i).comentarios.size() + "coment�rios \n";
				}
			}
		}
		else{
			cards = "\nVoc� n�o possui cart�es\n";
			cardArq = "\nAida n�o h� cart�es arquivados\n";
		}
		
		return "\n *---Cart�es---*\n" + cards + "\n*---Cart�es Arquivados---*\n" + cardArq +"\n";
			
		}
	
	public String infoCartao(String nomeQ,String nomeLista,String card) {
		String infoCard = "\nDescri��o: " + this.listador.acessarCartao(card, nomeLista, nomeQ).descricao + "\n Etiquetas: \n";
		if(!this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.isEmpty())
			for(int j = 0; j < this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.size();j++)
				infoCard = infoCard + "Etiqueta-> " + this.listador.acessarCartao(card, nomeLista, nomeQ).etiquetas.get(j).nome + "\n";
		if(!this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.isEmpty())
			for(int i = 0; i < this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.size();i++)
			infoCard = infoCard + "Coment�rio-> " + this.listador.acessarCartao(card, nomeLista, nomeQ).comentarios.get(i) + "\n";
		else
			infoCard += "\n n�o h� coment�rios";
		
		return infoCard;
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
