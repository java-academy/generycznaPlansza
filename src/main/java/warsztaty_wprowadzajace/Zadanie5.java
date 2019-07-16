package warsztaty_wprowadzajace;


import java.util.Arrays;
import java.util.List;

/**
 * <h1>Dziedziczenie a generyki!</h1>
 * <p>
 * Koniec z klonowaniem. Wokalistów i tak jest za dużo.
 * Ale co z nimi zrobić? Może by ich tak <i>sys.outnąć</i>?
 * <p>
 *
 * @author Wojciech Makiela
 */
public class Zadanie5 {

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

    private static void wyświetlWokalistów(List<Wokalista> wokaliści) {
        for (Wokalista wokalista : wokaliści) {
            System.out.println(wokalista);
        }
    }

    public static void main(String[] args) {
        List<Wokalista> jacyśWokaliści = Arrays.asList(
                new Wokalista("Rock"),
                new Wokalista("Blues"));
        wyświetlWokalistów(jacyśWokaliści);

        List<ElvisPresley> listaZPresleyem = Arrays.asList(new ElvisPresley());
//        wyświetlWokalistów(listaZPresleyem);

        /*
        No to co. Mamy listę jakichś wokalistów. Wrzucamy ją do 'wyświetlWokalistów' i wszystko fajnie działa.
        Robimy sobie listę Elvisów i próbujemy wyświetlić ich (odkomentowanie
        linijki 'wyświetlWokalistów(listaZPresleyem);'). No i przypał. Błąd kompilacji.

        W obu przypadkach jest taka sama lista. Różnią się tylko typem parametru. Jeśli zmienimy typ listyZPresleyem
        na List<Wokalista>, to będzie działać. Tylko dlaczego List<ElvisPresley> nie jest podtypem List<Wokalista>?
        Odpowiedź w kodzie:

            List<Integer> ints = Arrays.asList(1, 2); // Robimy listę Integerów
            List<Number> nums = ints;                 // Tutaj jest błąd kompilacji, ale teraz go ignorujemy.
            nums.add(3.14);                           // Double rozszerza Number, więc da się dodać.
            ints.toString().equals("1, 2, 3.14");     // MamyPrzypałException! Double w liście Integerów

        Przypisanie listy Integerów do zmiennej typu List<Number> powoduje błąd kompilacji, ponieważ może to
        doprowadzić do zepsucia pierwszej listy (Double w liście Integerów).

        W tym przykładzie rodzicem List<Number> i List<Integer> jest Object - są rodzeństwem, a jak zapewne wiesz
        zmienną 'A' można przypisać do zmiennej typu 'B' tylko i wyłącznie gdy 'A' jest dzieckiem 'B'.


        No. To skoro już masz śladowe pojęcie na temat dziedziczenia przy generykach, to naprawisz 'wyświetlWokalistów'.
        Chcemy, by przyjmowała dowolną listę Wokalistów.
        Aby to osiągnąć użyjemy symbolu nieoznaczonego (ang. "wildcard"). Zacznijmy od zmany deklaracji naszej metody.

            private static void wyświetlWokalistów(List<?> wokaliści)

        Jeśli pierwszy raz widzisz ten zapis, może on się wydawać "jakiś dziwny", ale to prawidłowa składnia Javy.
        Kopiuj-wklej i się przekonaj.

        Wildcard reprezentuje nieznany / dowolny typ. Zostawiony sam sobie (bez żadnych ograniczeń) symbolizuje Object.
        Nie do końca to co chcieliśmy, więc po raz kolejny dzięki słówku 'extends' uratujemy świat!
        // Nie modyfikuj zawartości metody 'wyświetlWokalistów', tylko jej deklarację.
         */
    }
}
