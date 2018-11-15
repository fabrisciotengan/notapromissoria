/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emissornotapromissoria.resource;

/**
 *
 * @author Fabriscio
 */
public enum Numeral {
    ZERO("zero"), UM("um"), DOIS("dois"), TRES("três"), QUATRO("quatro"), CINCO("cinco"),
    SEIS("seis"), SETE("sete"), OITO("oito"), NOVE("nove"), DEZ("dez"),
    
    ONZE("onze"), DOZE("doze"), TREZE("treze"), QUATORZE("quatorze"), QUINZE("quinze"),
    DEZESEIS("dezeseis"), DEZESETE("dezesete"), DEZOITO("dezoito"), DEZENOVE("dezenove"),
    
    VINTE("vinte"), TRINTA("trinta"), QUARTENTA("quarenta"), CINQUENTA("cinquenta"), SESSENTA("sessenta"),
    SETENTA("setenta"), OITENTA("oitenta"), NOVENTA("noventa"), 
    
    CEM("cem"), CENTO("cento"), DUZENTOS("duzentos"), TREZENTOS("trezentos"), QUATROCENTOS("quatrocentos"), QUINHENTOS("quinhentos"),
    SEISCENTOS("seiscentos"), SETECENTOS("setecentos"), OITOCENTOS("oitocentos"), NOVECENTOS("novecentos"), MIL("mil");
    
    
    private final String valor;

    private Numeral(String valor) {
        this.valor = valor;
    }
    public String getValor(){
        return valor;
    }
}
