package warsztaty_wprowadzajace;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Czasy przed generykami</h1>
 *
 * <ol>
 *     <li>Stwórz nowy projekt w którym będziesz pracować na javie 4. #mantra</li>
 *     <li>Skopiuj i wklej tam metodę `róbRzeczyZListą()`.</li>
 *     <li>Zaimplementuj ją, i zobacz, jak straszne były czasy javy 4.</li>
 *     <li>Zaimplementowaną metodę wklej tutaj - jeśli nic nie skopałeś, to powinna się kompilować!</li>
 *     <li>Zaimplementuj metodę `róbRzeczyZGenerycznąListą()`</li>
 *     <li>Porównaj implementacje tych metod, a następnie przeczytaj podsumowanie na dole.</li>
 * </ol>
 *
 * @author Wojciech Makiela
 */
public class Zadanie1 {

    public static void main(String[] args) {
        róbRzeczyZListą();
        róbRzeczyZGenerycznąListą();
    }

    static void róbRzeczyZListą() {
        // Stwórz nową listę o nazwie 'strings'

        // Dodaj do niej elementy: 'pierwszy' i 'drugi'


        // Bądź niegrzecznym chłopcem i dodaj do listy 'new Integer(3)'
        // Autoboxing pojawił się w Javie 5, więc trzeba ręcznie zapakować '3' w 'new Integer'

        // Wygląda to źle, a IntelliJ nie pokazuje błędu...
        // Przypał wisi w powietrzu, ale kontynuuj

        // Wyciągnij pierwszy element z listy, i przypisz go do zmiennej typu 'String'
        String pierwszy; // = strings.get(0);

        // No i przypał. Błąd kompilacji. IntelliJ świeci czerwienią. W tle słychać syreny.
        // Przed wprowadzeniem generyków wszystkie kolekcje były kolekcjami obiektów.
        // Co za tym idzie - by przypisać nasz pierwszy element do zmiennej typu 'String' trzeba
        // użyć rzutowania! Dodaj je teraz.


        // No to co. Teraz zrób to samo dla ostatniego elementu (naszego Integera).
        String ostatni; // (String) strings.get(2);

        // Po odpaleniu metody powinien pojawić się wyjątek ClassCastException.
        // Robota w Javie 4 skończona. Wróć do warsztatowego repo.
    }

    static void róbRzeczyZGenerycznąListą() {
        // Stwórz listę parametryzowaną typem 'String' i nazwij ją 'strings'

        // Dodaj do niej elementy: 'pierwszy' i 'drugi'


        // Bądź niegrzecznym chłopcem i dodaj do listy 'new Integer(3)'

        // Hah! Compile error!
        // Zakomentuj tą linijkę tak, żeby dalej się kompilowało.

        // Wyciągnij pierwszy element z listy, i przypisz go do zmiennej typu 'String'
        String pierwszy; // = strings.get(0);

        // Uruchom metodę.
    }

    /**
     * <h1>Podsumowanie:</h1>
     * <p>
     * Powinieneś teraz mieć 2 podobne implementacje. Jedną z użyciem generyków, a drugą w stylu retro.
     * Jeśli nie mogłeś napisać kodu w Javie 4 (z powodu przyczyn jak mniemam),
     * to przeklej tutaj gotowca dostępnego w katalogu resources w pliku 'RetroJava'.
     * </p>
     * <p>
     * Jak już wiesz, przed Javą 1.5 wszystkie kolekcje zawierały obiekty (Object).
     * Jako że wszystko w Javie jest obiektem, lub ma obiektowy odpowiednik (siema prymitywy), to
     * kolekcje były reużywalne.
     * Problem był jednak taki, że nie mogliśmy narzucać ograniczeń na to, co trafia do naszej kolekcji,
     * co mogło być źródłem wyjątków podczas wyciągania jej elementów.
     * </p>
     * I wtedy weszły one - Generyki. Bohaterowie na których zasługiwaliśmy.
     * Generyki pozwalają nam ograniczać typy elementów dodawanych do kolekcji, jak i dają znać kompilatorowi
     * jak dodać rzutowanie - czytaj dalej.
     */
    private static void howItWorks() {
        // <String> mówi kompilatorowi, że w naszej liście będą tylko instancje klasy 'String'
        List<String> strings = new ArrayList<>();

        // Kompilator uwzględnia tę informację i dokonuje sprawdzenia, czy elementy wkładane
        // do kolekcji są odpowiedniego typu.
        strings.add("pierwszy");
//        strings.add(new Integer(3)); // Błąd kompilacji

        // Wyciąganie elemetów przed Javą 1.5 wymagało ręcznego rzutowania.
        // Aktualnie kompilator sam dodaje odpowiednie rzutowanie w czasie kompilacji.
        // Finalnie bytecode wygenerowany podczas kompilacji zawiera informacje o rzutowaniach,
        // mimo tego, że nie ma ich w kodzie. Sprawia to, że kod źródłowy jest czystszy i łatwiejszy do zrozumienia.
        String first = strings.get(0);

        // Ale skoro lista ma 'Stringi', to po co tu rzutowanie? Coś mi tu śmierdzi...
        // O tym później. Najpierw trochę koderki z generykami, aby utrwalić zdobytą wiedzę.
    }
}