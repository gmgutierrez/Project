package dto.clases;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class cliente {
    public SimpleIntegerProperty codCliente= new SimpleIntegerProperty();
    public SimpleIntegerProperty tipoDto = new SimpleIntegerProperty();
    public SimpleStringProperty nroDto = new SimpleStringProperty();
    public SimpleStringProperty nomCliente = new SimpleStringProperty();
    private SimpleStringProperty estado = new SimpleStringProperty();
    private SimpleStringProperty fechaReg = new SimpleStringProperty();
/*
    public void setCodCliente(int codCliente) {
        this.codCliente.set(codCliente);
    }

    public void setTipoDto(int tipoDto) {
        this.tipoDto.set(tipoDto);
    }

    public void setNroDto(String nroDto) {
        this.nroDto.set(nroDto);
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente.set(nomCliente);
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public void setFechaReg(String fechaReg) {
        this.fechaReg.set(fechaReg);
    }

    public cliente(){
        this( 0, 0, "","","","");
    }
*/
    public cliente(int cod,int tipo,String nro, String nombre,String esta,String fecha){
        this.codCliente = new SimpleIntegerProperty(cod);
        this.estado = new SimpleStringProperty(esta);
        this.fechaReg = new SimpleStringProperty(fecha);
        this.nomCliente = new SimpleStringProperty(nombre);
        this.nroDto = new SimpleStringProperty(nro);
        this.tipoDto = new SimpleIntegerProperty(tipo);
    }

    public void print(){
        System.out.println(getCodCliente()+"////"+getTipoDto()+"////"+getNroDto()+"////"+getNomCliente()
                +"////"+getEstado()+"////"+getFechaReg());
    }

    public int getCodCliente() {
        return codCliente.get();
    }

    public int getTipoDto() {
        return tipoDto.get();
    }

    public String getNroDto() {
        return nroDto.get();
    }

    public String getNomCliente() {
        return nomCliente.get();
    }


    public String getEstado() {
        return estado.get();
    }

    public String getFechaReg() {
        return fechaReg.get();
    }

}
