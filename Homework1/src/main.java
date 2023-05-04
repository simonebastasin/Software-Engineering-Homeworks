import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//NOME STUDENTE: Simone Bastasin, NUMERO MATRICOLA: 1201543

//NOMI FILE TXT NECESSARI: "initialize_map.txt", "input_data.txt"

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Studente: Simone Bastasin, 1201543\n");
		System.out.println("HOMEWORK1: inizio del programma\n\n");
		
		int x = 0, y = 0, dim = 0;
		Cella[] map;
		String fileName = "", word = "";
		
		//raccolta dati da file: dimensione mappa
		try {
			fileName = "initialize_map.txt"; //nome file
			File myFile = new File(fileName); //possibile FileNotFoundException
			Scanner myReader = new Scanner(myFile);
		    word = myReader.nextLine();
		    x = Integer.parseInt(word); //numero colonne
		    word = myReader.nextLine();
		    y = Integer.parseInt(word); //numero righe
		    myReader.close();
		    if(x < 1 || y < 1 || x > 20 || y > 20) throw new Exception(); //errore numero di righe e colonne inserite
		    
		} catch (FileNotFoundException e) {
	    	System.out.println("\nErrore: file " + fileName + ": file non trovato\n");
	    	e.printStackTrace();
	    	System.exit(1);
	    } catch (NumberFormatException e) {
			System.out.println("\nErrore: file " + fileName + ": file non formattato correttamente\n");
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			System.out.println("\nErrore: file " + fileName + ": numero di righe e colonne devono entrambi essere compresi tra 1 e 20");
			System.out.println("L'utente ha inserito: " + x + " colonne e " + y + " righe\n");
			e.printStackTrace();
			System.exit(1);
		}
		
		dim = x*y;
	    System.out.println("Dimensioni mappa: \nx: " + x + ", y: " + y + ", numero celle: " + dim);
	    
	    //creazione mappa secondo le dimensioni fornite da file con celle vuote
	    map = new Cella[dim];
		for (int i = 0; i < dim; i++)
			map[i] = new Cella();
		
		MapInput(map, x, y); //raccolta dati da file: tipologia di ogni cella
		ItemsInput(map, x, y); //raccolta dati da file dei pezzi ed inserimento nelle rispettive celle
		
		System.out.println("\nOUTPUT:\n");
		
		NumeroPezziPerTipo(map, dim); //conta il numero di ogni tipo di pezzo in tutta la mappa
		
		CellaMaggioreDifesaGiorno(map, x, y); //stampa la cella con la maggior difesa di giorno
		CellaMaggioreDifesaNotte(map, x, y); //stampa la cella con la maggior difesa di notte
		
		CellaMaggioreAttaccoGiorno(map, x, y); //stampa la cella con il maggior attacco di giorno
		CellaMaggioreAttaccoNotte(map, x, y); //stampa la cella con il maggior attacco di notte
		
		CellaMaggioreNumPezziStessoTipo(map, x, y); //stampa la cella  con il maggior numero di pezzi dello stesso tipo
		
		System.out.println("\nHOMEWORK1: fine del programma\n");
	}
	
	//raccolta dati da file: tipologia di ogni cella
	static void MapInput(Cella[] map, int x, int y) {
		String fileName = "", word = "";
		try {
			fileName = "initialize_map.txt"; //nome file
			File myFile = new File(fileName); //possibile FileNotFoundException
			Scanner myReader = new Scanner(myFile);
		    word = myReader.nextLine(); //skip x, già letto nel main
		    word = myReader.nextLine(); //skip y, già letto nel main
		    int pos = 0; //posizione nell'array
		    int countRows = 0; //contatore del numero di righe nel file
		    
		    while(myReader.hasNextLine()) {
		    	word = myReader.nextLine();
		    	countRows++;
		    	
		    	if(word.length() == x) {
		    		for(int i = 0; i < x; i++) { //i: posizione per ogni linea
				    	if(word.charAt(i) == 'p') map[pos].type = "pianura";
				    	else if(word.charAt(i) == 'b') map[pos].type = "bosco";
				    	else if(word.charAt(i) == 'm') map[pos].type = "montagna";
				    	else throw new Exception(); //formattazione file incorretta sulla lettera usata per la tipologia della cella
				    	
				    	pos++;
		    		}
		    	}
		    	else throw new Exception(); //formattazione file incorretta della lunghezza di almeno una riga
		    }
		    
		    if(countRows < y || countRows > y) throw new Exception(); //formattazione file incorretta sul numero di righe inserite
		    
		    System.out.println("");
		    myReader.close();
		    
		} catch (FileNotFoundException e) {
	    	System.out.println("\nErrore: file " + fileName + ": file non trovato\n");
	    	e.printStackTrace();
	    	System.exit(1);
	    } catch (Exception e) {
			System.out.println("\nErrore: file " + fileName + ": file non formattato correttamente sulla stesura delle tipologie di celle della mappa\n");
			e.printStackTrace();
			System.exit(1);
		} 
	}
	
	//raccolta dati da file dei pezzi ed inserimento nelle rispettive celle
	static void ItemsInput(Cella[] map, int x, int y) {
		String fileName = "", word = "";
		try {
			fileName = "input_data.txt"; //nome file
			File myFile = new File(fileName); //possibile FileNotFoundException
		    Scanner myReader = new Scanner(myFile);
		    Tipo type = new Tipo();
		    int col = 0, row = 0; //column: x, row: y
		    int pos = 0; //posizione nell'array
		    
		    for(int i = 1; myReader.hasNextLine(); i++) {
		    	word = myReader.nextLine();
		    	if(i%3==1) col = Integer.parseInt(word);
		    	else if(i%3==2) row = Integer.parseInt(word);
		    	else if(i%3==0) {
		    		if(col <= 0 || row <= 0 || col > x || row > y) //se le coordiante desiderate non esistono
		    			System.out.println("Un tentativo di inserimento non è andato a buon fine, coordinate (" + col + "," + row + ") non valide");
		    		else { //altrimenti controllo di che tipo è il pezzo
			        	if(word.equals("elfo")) type = new Elfo();
			        	else if(word.equals("nano")) type = new Nano();
			        	else if(word.equals("orco")) type = new Orco();
			        	else throw new Exception(); //formattazione file incorretta
			            pos = (row - 1) * x + col - 1;
			        	map[pos].AddItem(type, col, row); //aggiunta pezzo alla cella
		    		}
		        }
		    }
		    System.out.println("");
		    myReader.close();
		    
	    } catch (FileNotFoundException e) {
	    	System.out.println("\nErrore: file " + fileName + ": file non trovato\n");
	    	e.printStackTrace();
	    	System.exit(1);
	    } catch (NumberFormatException e) {
	    	System.out.println("\nErrore: file " + fileName + ": file non formattato correttamente\n");
	    	e.printStackTrace();
	    	System.exit(1);
	    } catch (Exception e) {
	    	System.out.println("\nErrore: file " + fileName + ": file non formattato correttamente\n");
	    	e.printStackTrace();
	    	System.exit(1);
	    } 
	}
	
	//conta il numero di ogni tipo di pezzo in tutta la mappa
	static void NumeroPezziPerTipo(Cella[] map, int dim) {
		int[] counter = new int[3]; //3 celle: contano numero di ogni tipo di pezzo (3)
		for(int i = 0; i < dim; i++)
			map[i].Count(counter);
		
		System.out.println("Numero elfi: " + counter[0] + "");
		System.out.println("Numero nani: " + counter[1] + "");
		System.out.println("Numero orchi: " + counter[2] + "\n");
	}
	
	//stampa la cella con la maggior difesa di giorno
	static void CellaMaggioreDifesaGiorno(Cella[] map, int x, int y) {
		int pos = 0, def2 = 0;
		int def1 = map[0].DayDefence();
		
		for(int i = 1; i < x*y; i++) {
			def2 = map[i].DayDefence();
			if(def2 > def1) {
				pos = i;
				def1 = map[i].DayDefence();
			}
		}
		System.out.print("Casella con il maggior valore di difesa di giorno: ");
		PrintBox(pos, x); //stampa coordiante cella
	}
	
	//stampa la cella con la maggior difesa di notte
	static void CellaMaggioreDifesaNotte(Cella[] map, int x, int y) {
		int pos = 0, def2 = 0;
		int def1 = map[0].NightDefence();
		
		for(int i = 1; i < x*y; i++) {
			def2 = map[i].NightDefence();
			if(def2 > def1) {
				pos = i;
				def1 = map[i].NightDefence();
			}
		}
		System.out.print("Casella con il maggior valore di difesa di notte: ");
		PrintBox(pos, x); //stampa coordiante cella
	}
	
	//stampa la cella con il maggior attacco di giorno
	static void CellaMaggioreAttaccoGiorno(Cella[] map, int x, int y) {
		int pos = 0, atk2 = 0;
		int atk1 = map[0].DayAttack();
		
		for(int i = 1; i < x*y; i++) {
			atk2 = map[i].DayAttack();
			if(atk2 > atk1) {
				pos = i;
				atk1 = map[i].DayAttack();
			}
		}
		System.out.print("Casella con il maggior valore di attacco di giorno: ");
		PrintBox(pos, x); //stampa coordiante cella
	}
	
	//stampa la cella con il maggior attacco di notte
	static void CellaMaggioreAttaccoNotte(Cella[] map, int x, int y) {
		int pos = 0, atk2 = 0;
		int atk1 = map[0].NightAttack();
		
		for(int i = 1; i < x*y; i++) {
			atk2 = map[i].NightAttack();
			if(atk2 > atk1) {
				pos = i;
				atk1 = map[i].NightAttack();
			}
		}
		System.out.print("Casella con il maggior valore di attacco di notte: ");
		PrintBox(pos, x); //stampa coordiante cella
	}
	
	//stampa la cella  con il maggior numero di pezzi dello stesso tipo
	static void CellaMaggioreNumPezziStessoTipo(Cella[] map, int x, int y) {
		int pos = 0, num2 = 0;
		int num1 = map[0].SameItemsNumber();
		
		for(int i = 1; i < x*y; i++) {
			num2 = map[i].SameItemsNumber();
			if(num2 > num1) {
				pos = i;
				num1 = map[i].SameItemsNumber();
			}
		}
		System.out.print("Casella con il maggior numero di pezzi dello stesso tipo: ");
		PrintBox(pos, x); //stampa coordiante cella
	}
	
	//stampa coordinate cella
	static void PrintBox(int pos, int col) {
		//(pos%col + 1) per la coordinata x
		//(pos/col + 1) per la coordinata y
		System.out.println("(x,y) = (" + (pos%col + 1) + "," + (pos/col + 1) + ")\n");
	}

}
