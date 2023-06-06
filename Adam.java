package labirent4;

public class Adam extends Hucre{
	int a;
	@Override
	public String toString() {
		return "ö";
	}
	
	public Adam(Konum konum){
		super(konum);
	
	}
	
	public boolean hareketEttir(Hucre hucre){
		boolean hareketEtti = false;
		if(hucre instanceof Zemin || hucre instanceof Cikis){
			this.getKonum().setX(hucre.getKonum().getX());
			this.getKonum().setY(hucre.getKonum().getY());
			hareketEtti = true;
		}
		
		return hareketEtti;
	}
	
	

}
