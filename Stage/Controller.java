package Stage;

public interface Controller {
	
	//class Scan
	void setQrCode(String qr_Code);
	
	String getQrCode();
	
	String idGiverBis();
	
	boolean checkQrCode();
	
	boolean discount();
	
	//classe TPE
	
	void setMontant(double nMontant);
	
	double getMontant();
	
	void checkCode();
	
	void setSolde(double soldeBank);
	
	double getSolde();
	
	boolean sendRequest(double requestMontant);
	
	//classe Printer
	void setInfos(String ticketInfos);
	
	String getInfos();
	
	void print();
}