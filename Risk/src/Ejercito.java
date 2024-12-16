import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ejercito {
    private String color;
    private boolean ataca;
    private int tropas;
    private ArrayList<Integer> dados= new ArrayList<>();
    public Ejercito(String color, boolean ataca, int tropas) {
        this.color = color;
        this.ataca = ataca;
        this.tropas = tropas;
    }
    public void batallar(Ejercito ejercitoRival){
        dados=new ArrayList<>();
        ejercitoRival.setDados(new ArrayList<>());
        if(ataca){
            dados.add((Integer) (int)(Math.random()*6));
            dados.add((Integer) (int)(Math.random()*6));
            dados.add((Integer) (int)(Math.random()*6));
            ejercitoRival.getDados().add((Integer) (int) (Math.random()*6));
            ejercitoRival.getDados().add((Integer) (int)(Math.random()*6));
            Collections.sort(dados);
            Collections.sort(ejercitoRival.getDados());

            System.out.println("Nuevo turno: "+ dados +", "+ejercitoRival.getDados());

            if (dados.get(2)>ejercitoRival.getDados().get(1)){
                ejercitoRival.setTropas(ejercitoRival.getTropas()-1);
                System.out.println("Gana: "+color+": "+this.color+"("+getTropas()+") tirada:" +dados.get(2)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            } else if (dados.get(2)<ejercitoRival.getDados().get(1)) {
                setTropas(tropas-1);
                System.out.println("Gana: "+ejercitoRival.getColor()+": "+this.color+"("+getTropas()+") tirada:" +dados.get(2)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            }else{
                System.out.println("Empate: "+this.color+"("+getTropas()+") tirada:" +dados.get(2)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            }

            if (dados.get(1)>ejercitoRival.getDados().get(0)){
                ejercitoRival.setTropas(ejercitoRival.getTropas()-1);
                System.out.println("Gana: "+color+": "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(0));
            } else if (dados.get(1)<ejercitoRival.getDados().get(0)) {
                setTropas(tropas-1);
                System.out.println("Gana: "+ejercitoRival.getColor()+": "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(0));
            }else{
                System.out.println("Empate: "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(0));
            }

        }
        if(!ataca){
            dados.add((Integer) (int)(Math.random()*6));
            dados.add((Integer) (int)(Math.random()*6));
            ejercitoRival.getDados().add((Integer) (int) (Math.random()*6));
            ejercitoRival.getDados().add((Integer) (int) (Math.random()*6));
            ejercitoRival.getDados().add((Integer) (int) (Math.random()*6));
            Collections.sort(dados);
            Collections.sort(ejercitoRival.getDados());

            System.out.println("Nuevo turno: "+ dados +", "+ejercitoRival.getDados());

            if (dados.get(1)>ejercitoRival.getDados().get(2)){
                ejercitoRival.setTropas(ejercitoRival.getTropas()-1);
                System.out.println("Gana: "+color+": "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(2));
            } else if (dados.get(1)<ejercitoRival.getDados().get(2)) {
                setTropas(tropas-1);
                System.out.println("Gana: "+ejercitoRival.getColor()+": "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(2));
            }else{
                System.out.println("Empate: "+this.color+"("+getTropas()+") tirada:" +dados.get(1)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(2));
            }

            if (dados.get(0)>ejercitoRival.getDados().get(1)){
                ejercitoRival.setTropas(ejercitoRival.getTropas()-1);
                System.out.println("Gana: "+color+": "+this.color+"("+getTropas()+") tirada:" +dados.get(0)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            } else if (dados.get(0)<ejercitoRival.getDados().get(1)) {
                setTropas(tropas-1);
                System.out.println("Gana: "+ejercitoRival.getColor()+": "+this.color+"("+getTropas()+") tirada:" +dados.get(0)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            }else{
                System.out.println("Empate: "+this.color+"("+getTropas()+") tirada:" +dados.get(0)+", "+ejercitoRival.color+"("+ejercitoRival.getTropas()+") tirada:" +ejercitoRival.getDados().get(1));
            }

        }
        this.invertirTurno();
        ejercitoRival.invertirTurno();
    }

    public ArrayList<Integer> getDados() {
        return dados;
    }

    public int getTropas() {
        return tropas;
    }

    public void setTropas(int tropas) {
        this.tropas = tropas;
    }
    public String getColor() {
        return color;
    }

    public void setDados(ArrayList<Integer> dados) {
        this.dados = dados;
    }

    public void invertirTurno() {
        if(ataca){
            ataca = false;
        }else{
            ataca = true;
        }
    }
}
