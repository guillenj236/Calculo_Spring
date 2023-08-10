package br.com.springAtividade.demo.service;

import br.com.springAtividade.demo.dto.CalculoDTO;
import br.com.springAtividade.demo.dto.EntradaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@Service
public class CalculoService {
    public CalculoDTO calcular(EntradaDTO entrada){

        if(entrada.getNumeros().size()<20)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        else{
            CalculoDTO calculo = new CalculoDTO();
            calculo.setQtdDados(entrada.getNumeros().size());
            calculo.setMedia(this.media(entrada));
            calculo.setMediana(this.mediana(entrada));
            calculo.setDesvioPadrao(this.desvioPadrao(entrada));
            return calculo;
        }

    }
    private double media(EntradaDTO entrada){
        int soma = 0;
        for(int i=0;i<entrada.getNumeros().size();i++){
            soma += entrada.getNumeros().get(i);
        }
        return soma/entrada.getNumeros().size();
    }
    private double mediana(EntradaDTO entrada){

        Collections.sort(entrada.getNumeros());

        if(entrada.getNumeros().size() % 2 == 0){
            int posicaoDir= entrada.getNumeros().size() / 2;
            int posicaoEsq= posicaoDir -1 ;
            return ((entrada.getNumeros().get(posicaoDir) + entrada.getNumeros().get(posicaoEsq))/2);
        }else{
            double result = entrada.getNumeros().size() / 2;
            int posicao = (int) result;
            return entrada.getNumeros().get(posicao);
        }
    }
    private double desvioPadrao(EntradaDTO entrada){
        double soma = 0;
        for(int i=0;i<entrada.getNumeros().size();i++){
            double aux = (entrada.getNumeros().get(i) - this.media(entrada));
            double resultado = aux * aux;
            soma+=resultado;
        }
        double result = soma/entrada.getNumeros().size();
        return Math.sqrt(result);
    }
}
