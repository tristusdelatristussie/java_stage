package Stage;
import java.util.Scanner;

public class TPE implements Controller{
	
	private double Montant;
	private double solde;
	private static int code;
	
	private static Scanner sc = new Scanner(System.in);
	
	//objet de la classe Scan
	static Scan qrScan = new Scan();
	
	//objet de la classe Printer
	static Printer printNow = new Printer();
	
	//méthodes propres à la classe
	
	public void setMontant(double nMontant){
		
		this.Montant = nMontant;
	}
	
	public double getMontant(){
		
		return Montant;
	}
	
	public void checkCode(){
		
		double enteredCode = sc.nextDouble();
		int attemp = 0;
		
		while(!(enteredCode != code)){
			
			double pre = getMontant();
			
			sendRequest(pre);
			
			break;
		}
		
		attemp++;
		
		if(attemp == 3){
			
			System.exit(0);
		}
		
		checkCode();
	}
	
	public void setSolde(double soldeBank){
		
		this.solde = soldeBank;
	}
	
	public double getSolde(){
		
		return solde;
	}
	
	public boolean sendRequest(double requestMontant){
		
		if(requestMontant < solde){
			
			System.exit(0);
			
			return false;
		}
		
		else{
			
			this.solde = getSolde();
			
			this.solde = solde - Montant;
			
			return true;
		}
	}
	
	//méthodes de la classe Scan
	@Override
	public void setQrCode(String qr_Code) {
		
		qrScan.setQrCode(qr_Code);
	}

	@Override
	public String getQrCode() {
		
		return qrScan.getQrCode();
	}
	
	@Override
	public String idGiverBis() {
		
		return getQrCode();
	}
	
	@Override
	public boolean checkQrCode() {
		
		if(qrScan.checkQrCode() == true){
			
			return  true;
		}
		
		return false;
	}

	@Override
	public boolean discount() {
		
		if(qrScan.discount() == true){
			
			return true;
		}
		
		else{
			
			return false;
		}
	}
	
	//méthodes de classe Printer
	@Override
	public void setInfos(String ticketInfos) {
		
		printNow.setInfos(ticketInfos);
	}

	@Override
	public String getInfos() {
		
		return printNow.getInfos();
	}

	@Override
	public void print() {
		
		printNow.print();
	}
	
}