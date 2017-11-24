package dto.clases;

public class pedido {
	private int codPedido;
	private String fecha;
	private float total;

	public pedido(int codpedido,String fechas,float tot){
		setCodPedido(codpedido);
		setFecha(fechas);
		setTotal(tot);
	}

	public void print(){
		System.out.println(getCodPedido()+"////"+getFecha()+"////"+getTotal());
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
}
