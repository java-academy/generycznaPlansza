package workshop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * <h1>Typy ograniczone! Część 2!</h1>
 * <p>
 * Ograniczałeś już generyki od góry. Fajnie.
 * Ale czy wiedziałeś, że można je również ograniczyć od dołu?
 *
 * @author Wojciech Makiela
 */
public class Zadanie6 {

    static class Wokalista {
        private String gatunekMuzyczny;

        Wokalista(String gatunekMuzyczny) {
            this.gatunekMuzyczny = gatunekMuzyczny;
        }

        @Override
        public String toString() {
            return "Wokalista{" +
                    "gatunekMuzyczny='" + gatunekMuzyczny + '\'' +
                    '}';
        }
    }

    static class ElvisPresley extends Wokalista {

        ElvisPresley() {
            super("Rock'n'Roll");
        }
    }

    private static void róbCośZWokalistami(List<? extends Wokalista> wokaliści, Consumer<Wokalista> consumer) {
        for (Wokalista wokalista : wokaliści) {
            consumer.accept(wokalista);
        }
    }

    public static void main(String[] args) {

        /*
        Wcześniej napisałeś metodę, która wyświetla wokalistów.
        Zamiast tego użyjmy konsumenta - pozwoli nam to na polimorfizm zachowań!
         */

        Consumer<Wokalista> zamieńNaGwiazdęKPopu = wokalista -> wokalista.gatunekMuzyczny = "KPop";
        List<Wokalista> wokaliści = Arrays.asList(new ElvisPresley());
        róbCośZWokalistami(wokaliści, zamieńNaGwiazdęKPopu);
        System.out.println(wokaliści.get(0).gatunekMuzyczny); // Elvis jest teraz gwazdą KPop! Oh no!

        /*
        Szybkie przypomnienie czym jest konsument.
        Interfejs funkcyjny -> przyjmuje pewien parametr (w tym przypadku Wokalista) i go obrabia w pewien sposób.
         */

        // No ale jest problem. Oczywiście, że jest jakiś problem...
        Consumer<Object> print = System.out::println;
//        róbCośZWokalistami(wokaliści, print); // Błąd kompilacji - odkomentuj i się przekonaj!

        /*

        Dobrze wiem, że wokalistę da się sys.outnąć.
        Ty też to wiesz.
        Ale kompilator niestety nie. A przynajmniej tak to wygląda.

        Nasza metoda przyjmuje konsumenta wokalistów (dalej zwany kanibalem), a nie konsumenta obiektów.
        I co tu zrobić?
        <T extends Wokalista>?
        Może <?> ?
        Cholibka. Nie działa. Co tu zrobić... wcale nie przeczytałeś dokumentacji na samej górze, i nie wiesz
        że będziemy tu ograniczać generyki od dołu...

        Użycie 'extends' daje znać, że poszukujemy podklasy Wokalisty, ale w tym przypadku nie potrzebujemy podklasy.
        Potrzebujemy nadklasy!

        Do tej pory używałeś wyłącznie 'extends' - definicji górnej granicy parametru.
        Innymi słowy wskazywałeś najwyższą (na drzewie dziedziczenia) dopuszczalną klasę.

            Object
               |
            Wokalista
               |
          ElvisPresley

        <T extends Wokalista> mówi, że możemy użyć Wokalisty, lub czegokolwiek pod nim na drzewie.

        W tym przypadku jednak chcemy Wokalistę, lub cokolwiek powyżej - zdefiniować dolną granicę.
        By to zrobić używamy słowa kluczowego 'super'.
        Przykład:
            Poniżej znajdziesz metodę 'demo', która przyjmuje parametr typu List<? super Integer>.
            Przeanalizujmy ten zapis

                List        - Przyjmujemy jakiś obiekt implementujący interfejs List.
                <?          - Będzie ona przechowywać dowolne obiekty...
                super       - ... będące nadklasą...
                Integer>    - klasy Integer.

            Wywołania metody 'demo' są zakomentowane tylko po to, by nie rozpraszać Cię podczas pierwszej części.
            Odkomentuj je teraz i zobacz, że nasza metoda przyjmuje List<Integer>, List<Number>, oraz List<Object>.
         */

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        demo(integers);

        List<Number> numbers = new ArrayList<>(integers);
        numbers.add(3.14);
        demo(numbers);

        List<Object> objects = new ArrayList<>(numbers);
        objects.add(new Object());
        demo(objects);


        // Jak już przeanalizujesz co tu się odprzedsięwziewa, popraw metodę 'róbCośZWokalistami' tak,
        // by przyjmowała zarówno kanibala, jak i konsumenta obiektów.
    }

    private static void demo(List<? super Integer> list) {
        for (Object o : list) {
            System.out.print(o);
            System.out.print(", ");
        }
        System.out.println();
    }
}
