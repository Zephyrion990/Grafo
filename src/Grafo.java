
import java.util.*;

public class Grafo {
    private List<Vertice> vertices;
    private List<Arco> arcos;

    public Grafo() {
        vertices = new ArrayList<>();
        arcos = new ArrayList<>();
    }

    public void agregarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void agregarArco(Arco arco) {
        arcos.add(arco);
    }

    public void recorridoAnchura(Vertice inicio) {
        Queue<Vertice> cola = new LinkedList<>();
        Set<Vertice> visitados = new HashSet<>();

        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            System.out.println(actual.getDato());

            for (Arco arco : arcos) {
                if (arco.getInicio().equals(actual) && !visitados.contains(arco.getFin())) {
                    cola.add(arco.getFin());
                    visitados.add(arco.getFin());
                }
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");
        Vertice v4 = new Vertice("4");
        Vertice v5 = new Vertice("5");
        Vertice v6 = new Vertice("6");
        Vertice v7 = new Vertice("7");
        Vertice v8 = new Vertice("8");
        Vertice v9 = new Vertice("9");

        grafo.agregarVertice(v1);
        grafo.agregarVertice(v2);
        grafo.agregarVertice(v3);
        grafo.agregarVertice(v4);
        grafo.agregarVertice(v5);
        grafo.agregarVertice(v6);
        grafo.agregarVertice(v7);
        grafo.agregarVertice(v8);
        grafo.agregarVertice(v9);

        grafo.agregarArco(new Arco(v1, v2, 1));
        grafo.agregarArco(new Arco(v1, v8, 1));
        grafo.agregarArco(new Arco(v2, v1, 1));
        grafo.agregarArco(new Arco(v2, v4, 1));
        grafo.agregarArco(new Arco(v2, v3, 1));
        grafo.agregarArco(new Arco(v3, v2, 1));
        grafo.agregarArco(new Arco(v3, v4, 1));
        grafo.agregarArco(new Arco(v3, v5, 1));
        grafo.agregarArco(new Arco(v5, v3, 1));
        grafo.agregarArco(new Arco(v5, v6, 1));
        grafo.agregarArco(new Arco(v6, v5, 1));
        grafo.agregarArco(new Arco(v6, v7, 1));
        grafo.agregarArco(new Arco(v7, v4, 1));
        grafo.agregarArco(new Arco(v7, v6, 1));
        grafo.agregarArco(new Arco(v7, v9, 1));
        grafo.agregarArco(new Arco(v8, v1, 1));
        grafo.agregarArco(new Arco(v8, v9, 1));
        grafo.agregarArco(new Arco(v9, v8, 1));
        grafo.agregarArco(new Arco(v9, v7, 1));

        System.out.println("Recorrido de anchura:");
        grafo.recorridoAnchura(v1);
    }
}