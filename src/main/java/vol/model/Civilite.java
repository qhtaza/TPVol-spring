package vol.model;

public enum Civilite {
	MLLE("Mademoiselle"), M("Monsieur"), MME("Madame");
	
	private final String civi;

	private Civilite(String civi) {
		this.civi = civi;
	}

	public String getCivi() {
		return civi;
	}
	
}
