package Asset;

import java.awt.Graphics;

public class ApplicationForm {

	private String CT;
	private String IP;
	private String IPer;
	private String TIF;
	private String GC;
	private Graphics g;

	public ApplicationForm(String CT, String IP, String IPer, String TIF, String GC) {
		this.CT = CT;
		this.IP = IP;
		this.IPer = IPer;
		this.TIF = TIF;
		this.GC = GC;
	}

	public String getCT() {
		return CT;
	}

	public void setCT(String cT) {
		CT = cT;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public String getIPer() {
		return IPer;
	}

	public void setIPer(String iPer) {
		IPer = iPer;
	}

	public String getTIF() {
		return TIF;
	}

	public void setTIF(String tIF) {
		TIF = tIF;
	}

	public String getGC() {
		return GC;
	}

	public void setGC(String gC) {
		GC = gC;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

}
