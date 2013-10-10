package Negocio;



public enum TipoEntidadBancaria {       
    Banco,Caja,CoopCredito,EstabCredito,CajaAhorro;
   
private String TipoEntidadBancaria;
    

public String getTipoEntidadBancaria(){      
        return TipoEntidadBancaria;
    }

    public void setNombre(String tipoEntidadBancaria){
       TipoEntidadBancaria=tipoEntidadBancaria;
    }
    
}
