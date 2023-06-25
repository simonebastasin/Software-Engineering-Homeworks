
public class Cella {

	String type; //tipologia di cella (pianura/montagna/bosco)
	Tipo[] items; //contenitore pezzi di ogni cella
	
	//costruttore di default
	Cella() {
		this(""); //chiamata al costruttore di default con stringa vuota (per il type)
	}
	
	//costruttore generico
	Cella(String word) {
		type = word;
		items = new Tipo[5];
	}
	
	//aggiunta pezzo alla cella
	void AddItem(Tipo item, int x, int y) {		
		boolean added = false;
		String word = "";
		
		for(int i = 0; i < items.length && !added; i++)
			if(items[i] == null) { //controllo la presenza di spazio
				items[i] = item; //aggiunta
				added = true;			
			}
		if(item.attack == 5) word = "Elfo";
		else if(item.attack == 2) word = "Nano";
		else if(item.attack == 4) word = "Orco";
		
		if(added) //se è stato aggiunto
			System.out.println(word + " aggiunto in: (" + x + "," + y + ")");
		else //altrimenti (se non è stato aggiunto)
			System.out.println("Mappa già piena, " + word + " non aggiunto");
	}
	
	//contatore di ogni pezzo della cella
	void Count(int[] vett) {
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				if(items[i].attack == 5) vett[0] += 1; //elfi += 1;
				else if(items[i].attack == 2) vett[1] += 1; //nani += 1;
				else if(items[i].attack == 4) vett[2] += 1; //orchi += 1;
			}
		}
	}
	
	//difesa della cella di giorno
	int DayDefence() {
		int boxDef = 0;
		int def[] = new int[items.length];

		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				def[i] = items[i].defence;
				if(def[i] == 4) def[i] *= 0.5; 
				if(type == "bosco" && def[i] == 2) def[i] *= 2;
				boxDef += def[i];
			}
		}
		return boxDef;
	}

	//difesa della cella di notte
	int NightDefence() {
		int boxDef = 0;
		int def[] = new int[items.length];
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				def[i] = items[i].defence;
				if(def[i] == 4) def[i] *= 1.5; 
				if(type == "bosco" && def[i] == 2) def[i] *= 2;
				boxDef += def[i];
			}
		}
		return boxDef;
	}
	
	//attacco della cella di giorno
	int DayAttack() {
		int boxAtk = 0;
		int atk[] = new int[items.length];
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				atk[i] = items[i].defence;
				if(atk[i] == 4) atk[i] *= 0.5; 
				if(type == "montagna" && atk[i] == 2) atk[i] *= 2;
				boxAtk += atk[i];
			}
		}
		return boxAtk;
	}

	//attacco della cella di notte
	int NightAttack() {
		int boxAtk = 0;
		int atk[] = new int[items.length];
		
		for(int i = 0; i < items.length; i++) {
			if(items[i] != null) {
				atk[i] = items[i].defence;
				if(atk[i] == 4) atk[i] *= 1.5; 
				if(type == "montagna" && atk[i] == 2) atk[i] *= 2;
				boxAtk += atk[i];
			}
		}
		return boxAtk;
	}
	
	//contatore del tipo di pezzo più presente nella cella
	int SameItemsNumber() {
		int[] counter = {0, 0, 0}; //elfi, nani, orchi
		Count(counter);
		
		int max = counter[0];
		for(int i = 1; i < counter.length; i++) {
			if(counter[i] > max) max = counter[i];
		}
		return max;
	}
	
}
