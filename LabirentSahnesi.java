package labirent4;

public class LabirentSahnesi extends Sahne{
	
	public static final int ZEMIN = 1;
	public static final int DUVAR = 2;
	public static final int ADAM = 3;
	public static final int CIKIS = 4;
		
	public LabirentSahnesi(){
		super();
	}
	
	public LabirentSahnesi(int[][] labirent){
		super(labirent);
	}
	
	public void yukle(int[][] labirent){
		
		hucreler = new Hucre[labirent.length][labirent[0].length];
		
		for (int y = 0; y < labirent.length; y++){
			for(int x = 0; x < labirent[y].length; x++){
				int hucre = labirent[y][x];
				switch(hucre){
					case ZEMIN:
						hucreler[y][x] = new Zemin(new Konum(x,y));
						break;
					case DUVAR:
						hucreler[y][x] = new Duvar(new Konum(x,y));
						break;
					case ADAM:
						hucreler[y][x] = new Adam(new Konum(x,y));
						break;
					case CIKIS:
						hucreler[y][x] = new Cikis(new Konum(x,y));
						break;
				}
			}
		}
	}
	
	public Adam getAdam() {
		Adam adam = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof Adam)
					adam = (Adam)hucre;
			}
		}

		return adam;
	}
	

	public Cikis getCikis() {
		Cikis cikis = null;
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				Hucre hucre = hucreler[y][x];
				if(hucre instanceof Cikis)
					cikis = (Cikis)hucre;
			}
		}

		return cikis;

	}


	public String toString(){
		String s = "";
		for (int y = 0; y < hucreler.length; y++){
			for(int x = 0; x < hucreler[y].length; x++){
				s += (hucreler[y][x]).toString();
			}
			s +="\n";
		}
		return s;
	}

		
	

	
	
	@Override
	public void yukle(String dosyaAdi) {
		
	}

}
