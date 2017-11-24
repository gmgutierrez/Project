package dto.clases;

public class producto {
	private int codProducto;
	private String tipoProducto;
	private String marca;
	private String nombre;
	private String unidadMedida;
	private String modelo;
	private int cantidad;
	private float precioCosto;
	private int stock;
	private float margen;

	public producto(int codproducto,String tipo,String marcas, String name,String und,String model,int cant,float preciocosto,int stocks,float margens){
		setCodProducto(codproducto);
		setNombre(name);
		setModelo(model);
		setCantidad(cant);
		setPrecioCosto(preciocosto);
		setStock(stocks);
		setMargen(margens);
		setMarca(marcas);
		setTipoProducto(tipo);
		setUnidadMedida(und);
	}

	public void print(){
		System.out.println(getCodProducto()+"////"+getNombre()+"////"+getModelo()
				+"////"+getCantidad()+"////"+getPrecioCosto()+"////"+getStock()
				+"////"+getMargen());
	}
	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecioCosto() {
		return precioCosto;
	}

	public void setPrecioCosto(float precioCosto) {
		this.precioCosto = precioCosto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getMargen() {
		return margen;
	}

	public void setMargen(float margen) {
		this.margen = margen;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}
