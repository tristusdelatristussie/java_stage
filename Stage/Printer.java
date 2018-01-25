package Stage;

public class Printer implements Controller{
	
	private String infos;
	
	//objet de la classe Scan
	static Scan qrScan = new Scan();
	
	//objet de la classe TPE
	static TPE boolPrintTPE = new TPE();
	
	//méthodes propres à la classe
	public void setInfos(String ticketInfos){
		
		this.infos = ticketInfos;
	}
	
	public String getInfos(){
		
		return infos;
	}
	
	public void print(){
		
		double checkPrint = boolPrintTPE.getMontant();
		
		if(boolPrintTPE.sendRequest(checkPrint) == true){
			
			Printer actPrint = new Printer();
			
			actPrint.setInfos(getInfos());
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
	
	//méthodes de la classe TPE
	
	@Override
	public void setMontant(double nMontant) {
		
		boolPrintTPE.setMontant(nMontant);
	}
	
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
		
		return boolPrintTPE.sendRequest(requestMontant);
	}

}