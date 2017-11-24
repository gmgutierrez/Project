package dto.clases;

public class compra {
	private int codCompra;
    private int codProveedor;
    private int numDocumento;
    private float subTotal;
    private float IGV;
	private String fecha;

	public compra(int codcompra,int codproveedor,int numdocumento,float subtotal,float igv,String fechas){
        codCompra=codcompra;
        codProveedor=codproveedor;
        numDocumento=numdocumento;
        subTotal=subtotal;
        IGV=igv;
        fecha=fechas;
    }
    public void print(){
        System.out.println(getCodCompra()+"////"+getCodProveedor()+"////"+getNumDocumento()
                +"////"+getSubTotal()+"////"+getIGV()+"////"+getFecha());
    }
	public int getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(int codCompra) {
		this.codCompra = codCompra;
	}

	public int getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(int codProveedor) {
		this.codProveedor = codProveedor;
	}

	public int getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(int numDocumento) {
		this.numDocumento = numDocumento;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
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
