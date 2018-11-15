/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emissornotapromissoria;

import emissornotapromissoria.resource.Numeral;

/**
 *
 * @author Fabriscio
 */
public class NumeroConverter {
    
    public static String montaNomeExtenso(String numero){
        StringBuffer nome = new StringBuffer();
        char[] algarismos = numero.toCharArray();
        char ultimoNum = algarismos[algarismos.length - 1];
        char penultimoNum = algarismos[algarismos.length - 2];
        boolean sohCentavos = false;
        if(numero != null){
            switch(numero.length()){
                case 4: 
                    //0-9
                    if(algarismos[0] != '0'){
                        nome.append(retornaNomeNumero(algarismos[0]));
                        if(algarismos[0] == '1'){
                            nome.append(" real");
                        } else {
                            nome.append(" reais");
                        }
                    } else {
                        sohCentavos = true;
                    }
                    break;  
                case 5: 
                    //10-99
                    nome.append(retornaDezena(algarismos[0], algarismos[1]));
                    nome.append(" reais");
                    break;
                case 6: 
                    //100-999
                    boolean cemRedondo = (algarismos[1] == '0' && algarismos[2] == '0');
                    nome.append(concatenaCentena(algarismos[0], cemRedondo));
                    nome.append(retornaDezena(algarismos[1], algarismos[2]));
                    nome.append(" reais");
                    break;
                case 7: 
                    //1000+9000
                    boolean cemRedondo1 = (algarismos[2] == '0' && algarismos[3] == '0');
                    nome.append(concatenaMilhar(algarismos[0], algarismos));
                    nome.append(retornaDezena(algarismos[2], algarismos[3]));
                    nome.append(" reais");
                    break;
            }
            if(!(penultimoNum == '0' && ultimoNum == '0')){
                if(!sohCentavos){
                    nome.append(" e ");
                }
                nome.append(concatenaCentavos(penultimoNum, ultimoNum));
            }
        } else {
            nome.append("Número inválido");
        }
        return nome.toString();
    }
    private static String concatenaMilhar(char milhar, char[] numero){
        StringBuffer nome = new StringBuffer();
        boolean milRedondo = (numero[1] == '0' && numero[2] == '0' && numero[3] == '0');
        if(milhar != '1'){
            nome.append(retornaNomeNumero(milhar));
            nome.append(" " + Numeral.MIL.getValor());
        } else {
            nome.append(Numeral.MIL.getValor());
        }
        boolean cemRedondo = (numero[2] == '0' && numero[3] == '0');
        if(numero[1] != '0'){
            if(numero[1] == '1'){
                nome.append(" ");
            }else {
                nome.append(" e ");
            }
        }
        nome.append(concatenaCentena(numero[1], cemRedondo));
        return nome.toString();
    }
    private static String concatenaCentena(char centena, boolean cemRedondo){
        StringBuffer nome = new StringBuffer();
        switch(centena){
            case '1':
                if(cemRedondo){
                    nome.append(Numeral.CEM.getValor());
                } else {
                    nome.append(Numeral.CENTO.getValor());
                }
            break;
            case '2':
                nome.append(Numeral.DUZENTOS.getValor());
            break;
            case '3':
                nome.append(Numeral.TREZENTOS.getValor());
            break;
            case '4':
                nome.append(Numeral.QUATROCENTOS.getValor());
            break;
            case '5':
                nome.append(Numeral.QUINHENTOS.getValor());
            break;
            case '6':
                nome.append(Numeral.SEISCENTOS.getValor());
            break;
            case '7':
                nome.append(Numeral.SETECENTOS.getValor());
            break;
            case '8':
                nome.append(Numeral.OITOCENTOS.getValor());
            break;
            case '9':
                nome.append(Numeral.NOVECENTOS.getValor());
            break;
        }
        if(!cemRedondo){
            nome.append(" e ");
        }
        return nome.toString();
    }
    private static String concatenaCentavos(char penultimoNum, char ultimoNum){
        StringBuffer nome = new StringBuffer();
            nome.append(retornaDezena(penultimoNum, ultimoNum));
            if(penultimoNum == '0' && ultimoNum == '1'){
                nome.append(" centavo");
            } else {
                nome.append(" centavos");
            }
        return nome.toString();
    }
    private static String retornaDezena(char primeiraCasa, char segundaCasa){
        StringBuffer dezena = new StringBuffer();
        if(!(primeiraCasa == '0' && segundaCasa == '0')){
            //verifica se eh menor que 10
           if(primeiraCasa == '0'){
               dezena.append(retornaNomeNumero(segundaCasa));
           } else {
               if(primeiraCasa == '1'){
                   dezena.append(retornaDezenaSegundoNumero(segundaCasa));
               } else {
                   dezena.append(retornaDezenaPrimeiroNumero(primeiraCasa));
                   if(segundaCasa != '0'){
                       dezena.append(" e ");
                       dezena.append(retornaNomeNumero(segundaCasa));
                   }
               }
           }
        }
        return dezena.toString();
    }
    
    private static String retornaNomeNumero(char numero){
        switch(numero){
            case '0': return Numeral.ZERO.getValor();
            case '1': return Numeral.UM.getValor();
            case '2': return Numeral.DOIS.getValor();
            case '3': return Numeral.TRES.getValor();
            case '4': return Numeral.QUATRO.getValor();
            case '5': return Numeral.CINCO.getValor();
            case '6': return Numeral.SEIS.getValor();
            case '7': return Numeral.SETE.getValor();
            case '8': return Numeral.OITO.getValor();
            case '9': return Numeral.NOVE.getValor();
        }
        return "Número Inválido";
    }
    
    private static String retornaDezenaSegundoNumero(char numero){
        switch(numero){
            case '0': return Numeral.DEZ.getValor();
            case '1': return Numeral.ONZE.getValor();
            case '2': return Numeral.DOZE.getValor();
            case '3': return Numeral.TREZE.getValor();
            case '4': return Numeral.QUATORZE.getValor();
            case '5': return Numeral.QUINZE.getValor();
            case '6': return Numeral.DEZESEIS.getValor();
            case '7': return Numeral.DEZESETE.getValor();
            case '8': return Numeral.DEZOITO.getValor();
            case '9': return Numeral.DEZENOVE.getValor();
        }
        return "Número Inválido";
    }
    private static String retornaDezenaPrimeiroNumero(char numero){
        switch(numero){
            case '2': return Numeral.VINTE.getValor();
            case '3': return Numeral.TRINTA.getValor();
            case '4': return Numeral.QUARTENTA.getValor();
            case '5': return Numeral.CINQUENTA.getValor();
            case '6': return Numeral.SESSENTA.getValor();
            case '7': return Numeral.SETENTA.getValor();
            case '8': return Numeral.OITENTA.getValor();
            case '9': return Numeral.NOVENTA.getValor();
        }
        return "Número Inválido";
    }
}
