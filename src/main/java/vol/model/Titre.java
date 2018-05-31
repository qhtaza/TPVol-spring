package vol.model;

public enum Titre {
	PLC("Public_limited_company"), LTD("Private_company_limited_shares"), LLP("Limited_liability_partership");
	
	private final String titre;

	private Titre(String titre) {
		this.titre = titre;
	}

	public String getCivi() {
		return titre;
	}
	
}
