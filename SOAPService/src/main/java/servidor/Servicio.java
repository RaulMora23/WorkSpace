package servidor;

import javax.jws.WebService;
/**Esta clase se instancia del lado del servidor. El cliente solo maneja la interfaz,
 *  digamos que la interfaz es el continente
 * y la instancia el contenido*/
@WebService(endpointInterface = "servidor.ModeloServicio")
public class Servicio implements ModeloServicio {
    String[] equipos = {
            "0. Alavés",
            "1. Almería",
            "2. Athletic Club",
            "3. Atlético de Madrid",
            "4. Barcelona",
            "5. Betis",
            "6. Cádiz",
            "7. Celta de Vigo",
            "8. Getafe",
            "9. Girona",
            "10. Granada",
            "11. Las Palmas",
            "12. Mallorca",
            "13. Osasuna",
            "14. Rayo Vallecano",
            "15. Real Madrid",
            "16. Real Sociedad",
            "17. Sevilla",
            "18. Valencia",
            "19. Villarreal"
    };

    int[] plantillas = {25, 25, 24, 23, 24, 25, 24, 25, 25, 24, 25, 24, 25, 23, 24, 25, 24, 24, 24, 25};

    String[] entrenadores = {
            "Luis García Plaza", "Gaizka Garitano", "Ernesto Valverde", "Diego Simeone", "Xavi Hernández",
            "Manuel Pellegrini", "Mauricio Pellegrino", "Rafael Benítez", "José Bordalás", "Míchel",
            "Alexander Medina", "García Pimienta", "Javier Aguirre", "Jagoba Arrasate", "Francisco Rodríguez",
            "Carlo Ancelotti", "Imanol Alguacil", "Quique Sánchez Flores", "Rubén Baraja", "Marcelino García Toral"
    };

    @Override
    public String getEntrenador(int indice) {
        return entrenadores[indice];
    }

    @Override
    public int getPlantilla(int indice) {

        return plantillas[indice];
    }
    @Override
    public String getEquipos(){
        return String.join(",", equipos);
    }
}
