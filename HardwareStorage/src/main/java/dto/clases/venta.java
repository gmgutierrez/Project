package dto.clases;

public class venta {
	private int codVenta;
	private float subtotal;
	private float IGV;
	private String fecha;

	public venta(int cod,float sub,float igv,String fechas){
		setCodVenta(cod);
		setSubtotal(sub);
		setIGV(igv);
		setFecha(fechas);
	}
	public void print(){
		System.out.println(getCodVenta()+"////"+getSubtotal()+"////"+getIGV()+"////"+getFecha());
	}
	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getIGV() {
		return IGV;
	}

	public void setIGV(float IGV) {
		this.IGV = IGV;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
