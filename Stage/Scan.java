package Stage;
import java.util.Random;
import java.util.ArrayList;

public class Scan implements Controller{
	
	private String qrCode;
	private int checkout;
	
	static ArrayList <String> baseCust = new ArrayList <String>();
	static Random rd = new Random();
	
	//objet de la classe TPE
	static TPE boolPrintTPE = new TPE();
	
	//objet de la classe Printer
	static Printer printNow = new Printer();
	
	//méthodes propres à la classe
	public void setQrCode(String qr_Code){
		
		this.qrCode = qr_Code;
	}
	
	public String getQrCode(){
		
		return qrCode;
	}
	
	public String idGiverBis(){
		
		long a = rd.nextLong();
		
		String id = "";
		
		if(a < 0 || a < 1000000000000000000L){
			
			idGiverBis();
		}
		
		while(a > 0 && a > 999999999999999999L){
		
			String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			int[] tabNal = new int[6];
			
			for(int i = 0; i < tabNal.length; i++){
				
				tabNal[i] = (int)(Math.random()*(27-1)+0);
			}
			
			char[] tabletter = str.toCharArray();
			char[] x = new char[tabNal.length];
			
			for(int i = 0; i < tabletter.length; i++){
				
				for(int j = 0; j < tabNal.length; j++){
					
					if(i == tabNal[j]){
						
						x[j] = tabletter[i];
					}
				}
			}
			
			String lts = new String();
			
			lts = Long.toString(a);
			
			String ltr = new String(x);
			
			id = lts + ltr;
			
			for(int i = 0; i < baseCust.size(); i++){
				
				if(baseCust.get(i) == null){
					
					baseCust.add(id);
				}
			}
			
			Scan applyId = new Scan();
			
			applyId.setQrCode(id);
			
			break;
		}
		
		return id;
	}
	
	public boolean checkQrCode(){
		
		Scan qrExist = new Scan();
		
		for(int i = 0; i < baseCust.size(); i++){
			
			if(qrExist.equals(baseCust.get(i))){
				
				return true;
			}
		}
		
		return false;
	}
	
	
	
	public boolean discount(){
		
		Scan qrDiscount = new Scan();
		
		if(qrDiscount.checkQrCode() == false){
			
			qrDiscount.idGiverBis();
		}
		
		if(qrDiscount.checkQrCode() == true){
			
			checkout += 1;
			
			if(checkout == 5){
				
				TPE priceDown = new TPE();
				
				double lastPrice = priceDown.getMontant() - (priceDown.getMontant()*0.10);
				
				priceDown.setMontant(lastPrice);
				
				checkout = 0;
			}
			
			return true;
		}
		
		return false;
	}
	
	//méthodes de la classe TPE
	
	@Override
	public void setMontant(double nMontant) {
		
		boolPrintTPE.setMontant(nMontant);
	}
	
	
	//méthodes de la clase TPE
	@Override
	public double getMontant() {
		
		return boolPrintTPE.getMontant();
	}

	@Override
	public void checkCode() {
		
		boolPrintTPE.checkCode();
	}
	
	@Override
	public void setSolde(double soldeBank) {
		
		boolPrintTPE.setSolde(soldeBank);
	}
	

	@Override
	public double getSolde() {
		
		return boolPrintTPE.getSolde();
	}
	

	@Override
	public boolean sendRequest(double requestMontant) {
		
		if(boolPrintTPE.sendRequest(requestMontant) == true){
			
			return true;
		}
		
		else{
			
			return false;
		}
	}
	
	
	//méthodes de la classe Printer
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