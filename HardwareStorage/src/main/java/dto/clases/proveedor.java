package dto.clases;

public class proveedor {
	private int codProveedor;
	private String nomProveedor;
	private String rucProveedor;
	private String direccionProveedor;
	private String ciudadProveedor;
	private String telefProveedor;
	private String emailProveedor;
	private float formulaProveedor;
	private float factorProveedor;
	private String fechaReg;

	public proveedor(int cod,String nom,String ruc,String direccion,String ciudad,String telef
			,String email,float formula,float factor,String fechas){
		setCodProveedor(cod);
		setNomProveedor(nom);
		setRucProveedor(ruc);
		setDireccionProveedor(direccion);
		setCiudadProveedor(ciudad);
		setTelefProveedor(telef);
		setEmailProveedor(email);
		setFormuläProveedor(formula);
		setFactorProveedor(factor);
		setFechaReg(fechas);
	}

	public void print(){
		System.out.println(getCodProveedor()+"////"+getNomProveedor()+"////"+getRucProveedor()
				+"////"+getDireccionProveedor()+"////"+getCiudadProveedor()+"////"+getTelefProveedor()
				+"////"+getEmailProveedor()+"////"+getFormulaProveedor()+"////"+getFactorProveedor());
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}

	public String getNomProveedor() {
		return nomProveedor;
	}

	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}

	public String getRucProveedor() {
		return rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getTelefProveedor() {
		return telefProveedor;
	}

	public void setTelefProveedor(String telefProveedor) {
		this.telefProveedor = telefProveedor;
	}

	public String getEmailProveedor() {
		return emailProveedor;
	}

	public void setEmailProveedor(String emailProveedor) {
		this.emailProveedor = emailProveedor;
	}

	public float getFormulaProveedor() {
		return formulaProveedor;
	}

	public void setFormuläProveedor(float formuläProveedor) {
		this.formulaProveedor = formuläProveedor;
	}

	public float getFactorProveedor() {
		return factorProveedor;
	}

	public void setFactorProveedor(float factorProveedor) {
		this.factorProveedor = factorProveedor;
	}

	public String getFechaReg() {
		return fechaReg;
	}

	public void setFechaReg(String fechaReg) {
		this.fechaReg = fechaReg;
	}
}
