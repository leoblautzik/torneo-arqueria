
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Torneo {

    private Map<Integer,PriorityQueue<Integer>> participantes = new TreeMap<Integer, PriorityQueue<Integer>>();
    private TreeMap<Integer, LinkedList<Integer>> podio = new TreeMap<Integer,LinkedList<Integer>>(Collections.reverseOrder());

    public Torneo(String archivo) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(archivo));
        while(sc.hasNext()) {
            String [] datos = sc.nextLine().split(",");
            Integer key = Integer.parseInt(datos[0]);
            Integer puntaje = getPuntaje(Double.parseDouble(datos[1]),Double.parseDouble(datos[2]));

            if (puntaje > 0) {
                if(participantes.containsKey(key)) {

                    participantes.get(key).offer(puntaje);
                }else {
                    PriorityQueue<Integer> colaP = new PriorityQueue<Integer>(Collections.reverseOrder());
                    colaP.offer(puntaje);
                    participantes.put(key, colaP);
                }
            }	
        }
        sc.close();
    }

    public void getPodio() {
        //se da vuelta el mapa poniendo el puntaje como key y la lista de participantes como value
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : participantes.entrySet()) {
            //solo se consideran los arqueros con 5 tiros válidos o mas
            if (entry.getValue().size() >= 5) {
                Integer participante = entry.getKey();
                Integer suma = 0;
                for (int i = 0; i < 5; i++) {
                    suma += entry.getValue().poll();
                }
                if (podio.containsKey(suma))
                    podio.get(suma).add(participante);
                else {
                    LinkedList<Integer> listaP = new LinkedList<Integer>();
                    listaP.add(participante);
                    podio.put(suma, listaP);
                }
            }
        }
        //iteramos los 3 primeros lugares del podio
        Iterator<Map.Entry<Integer, LinkedList<Integer>>> itr = podio.entrySet().iterator(); 
        int i = 0;
        while(itr.hasNext() && i<3 ) 
        { 
            Map.Entry<Integer, LinkedList<Integer>> entry = itr.next(); 
            System.out.println(i+1 + "° puesto: " + entry.getKey() +" Puntos, Participantes: " + entry.getValue()); 
            i++;
        } 
    }

    private Integer getPuntaje(Double x, Double y) {
        Integer puntaje = 0;
        Double distanciaAlCentro = Math.sqrt(Math.pow(x, 2) + Math.pow(y,2));
        if (distanciaAlCentro <= 10)
            puntaje = 1000;
        if (distanciaAlCentro > 10 && distanciaAlCentro <= 20)
            puntaje = 500;
        if (distanciaAlCentro > 20 && distanciaAlCentro <= 30)
            puntaje = 200;
        if (distanciaAlCentro > 30 && distanciaAlCentro <= 40)
            puntaje = 100;
        if (distanciaAlCentro > 40 && distanciaAlCentro <= 50)
            puntaje = 500;
        if (distanciaAlCentro > 50) 
            puntaje = -1;
        return puntaje;
    }

    public static void main(String [] args) throws FileNotFoundException {
        Torneo arqueritosDelSur = new Torneo(args[0]);
        arqueritosDelSur.getPodio();
    }

}
