package labirent4;

import java.util.Scanner;

public class LabirentOyunu extends Oyun{

	public static final int YUKARI = 1;
	public static final int ASAGI = 2;
	public static final int SAGA = 3;
	public static final int SOLA = 4;
	public static final int HATALI = 0;

	
	public void yukle(){
	
	
		int[][] lab={{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
					{2, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
					{2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2},
					{2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
					{2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2},
					{2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
					{2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2},
					{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 2},
					{2, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
					{2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 2},
					{2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 1, 1, 2},
					{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2},
					{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 2},
					{2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 4, 2},
					{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
		
		sahne = new LabirentSahnesi(lab);
		
		
	}
		
	public void basla(){
		
		while(true){
			
			System.out.println(this);
			int girdi = kullanicidanYonBilgisiAl();
			guncelle(girdi);
			if(oyunBitti())
			{
				System.out.println("Tebrikler! Çıkışı buldunuz");
				break;
			}
				
		}
		
	}
	
	private int kullanicidanYonBilgisiAl() {
		
		Scanner consol = new Scanner(System.in);
		
		System.out.print("Yön Tuşları (w = yukarı, s = aşağı, a = sol, d = sağ), seçiniz: ");
		
		String secimStr = consol.next();
		
		char secim = secimStr.charAt(0);
		int yon = HATALI;
		
		switch(secim){
			case 'w':
			case 'W': 
				yon = YUKARI;
				break;
				
			case 'a':
			case 'A':
				yon = SOLA;
				break;
				
			case 's':
			case 'S':	
				yon = ASAGI;
				break;
				
			case 'd':
			case 'D':	
				yon = SAGA;
				break;
	
		}

		return yon;

	}

	private void guncelle(int girdi){
		
		Konum adamKonum = ((LabirentSahnesi)sahne).getAdam().getKonum();
		
		switch(girdi){
		
			case YUKARI:
				
				hareketEttir(adamKonum.getX(), adamKonum.getY()-1);
				break;
				
			case SOLA:
				hareketEttir(adamKonum.getX()-1, adamKonum.getY());
				break;
	
			case ASAGI:
				hareketEttir(adamKonum.getX(), adamKonum.getY()+1);
				break;
			
			case SAGA:
				hareketEttir(adamKonum.getX()+1, adamKonum.getY());				
				break;
		}


	}
	
	private void hareketEttir(int x, int y) {
		
		Adam adam = ((LabirentSahnesi)sahne).getAdam();
		Hucre hucre = ((LabirentSahnesi)sahne).getHucre(x, y);
		
		int eskiX = adam.getKonum().getX();
		int eskiY = adam.getKonum().getY();
		
		boolean hareketEtti = adam.hareketEttir(hucre);
		
		if(hareketEtti){
			sahne.setHucre(adam, x, y);
			hucre.getKonum().setX(eskiX);
			hucre.getKonum().setY(eskiY);
			sahne.setHucre(hucre, eskiX, eskiY);
			sahne.setSkor(sahne.getSkor()+1);
		}
		
	}

	private boolean oyunBitti(){
		LabirentSahnesi labs = (LabirentSahnesi)sahne;
		boolean oyunBitti = false; 
		if(labs.getAdam().getKonum().compareTo(labs.getCikis().getKonum()) == 0)
			oyunBitti = true;
		
		return oyunBitti;
	}
	
	public String toString(){
		String s = "-------------------------\n";
		s += sahne.toString();
		s += "\n Toplam Adım: "+sahne.getSkor();
		s += "\n-------------------------\n";
		
		return s;
	}

		

	

}
