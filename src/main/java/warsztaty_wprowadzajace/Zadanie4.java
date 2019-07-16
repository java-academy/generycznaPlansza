package warsztaty_wprowadzajace;


/**
 * <h1>Typy ograniczone!</h1>
 * <p>
 * Mamy takie klasy:
 * <ul>
 *     <li>Wokalista</li>
 *     <li>ElvisPresley</li>
 * </ul>
 * Niektórzy twierdzą, że Elvis nadal żyje, ponieważ został sklonowany.
 * <p><i>// Im mniej o tym myślisz tym bardziej logiczne się to wydaje.</i></p>
 * <p>
 * Zatem sprawimy, że nasza klasa ElvisPresley również będzie Klonowable.
 * <p>
 * <b>Ważna notka:</b>
 * Proszę nie modyfikuj żadnych klas ani interfejsów, chyba że dalsze polecenia stanowią inaczej.
 * <p>
 * Zapoznaj się z interfejsem Klonowable, klasami Wokalista i ElvisPresley, oraz metodą 'main'.
 * W 'main' wywołana jest metoda 'klonujWokalistę' -> zaimplementuj ją zgodnie z instrukcjami.
 *
 * @author Wojciech Makiela
 */
public class Zadanie4 {

    interface Klonowable<T> {
        T klonuj();
    }

    static class Wokalista {
        // Nie ruszać!
    }

    static class ElvisPresley extends Wokalista implements Klonowable<ElvisPresley> {
        // Nie ruszać!
        @Override
        public ElvisPresley klonuj() {
            return new ElvisPresley();
        }

        @Override
        public String toString() {
            return "ElvisPresley{}";
        }
    }

    public static void main(String[] args) {
        // Cała logika tego zadania znajdzie się w metodzie 'klonujWokalistę'.
        // 'main' powstał tylko żeby ułatwić Ci testowanie twoich rozwiązań.
        System.out.println(klonujWokalistę(new ElvisPresley()));
    }

    private static Klonowable klonujWokalistę(Klonowable klonowable) {
        return (Klonowable) klonowable.klonuj();
        /*
        Popatrz na to rzutowanie. Po kiego grzyba ono tu jest?
        Jak je usuniesz, to dostaniesz błąd. Zrób to, i przeczytaj opis błędu.

        Metoda 'klonuj' zwraca Object, a nie Klonowable. No i w sumie to ma to sens.
        Jak zerkniesz na interfejs Klonowable to zobaczysz typ zwrotny 'T', którym może być cokolwiek.
        W poprzednim zadaniu dowiedziałeś się, że w trakcie kompilacji typy generyczne zastępowane
        są obiektami (Object). I ma to sens. Wszak (prawie) wszystko w Javie jest obiektem, więc i nasz
        typ zwrotny 'T' jest traktowany jak obiekt.

        Jeśli pomyślimy chwilę nad klonowaniem, to możemy dojść do (szalonego) wniosku:

            Jeżeli Elvisa dało się sklonować, to tego klona też powinno się dać.

        Tymczasem nasz Elvis może implementować interfejs Klonowable<String> i dalej będzie to działało,
        choć nie będzie zbyt logiczne. Jeśli mi nie ufasz to sprawdź. Jeśli mi ufasz, to coś z tobą nie tak.

        Możesz to naprawić słówkiem kluczowym 'extends'.

        Jeśli zmienisz deklarację interfejsu Klonowable<T> na 'Klonowable<T extends Klonowable>'
        sprawisz, że implementowanie Klonowable<String> nie będzie możliwe.
        (właściwie Klonowable<cokolwiekCoNieImplementujeKlonowable> nie zadziała)
        Ważna notka - przy generykach używamy tylko słówka 'extends', nigdy 'implements', niezależnie czy mówimy
        o klasach, czy interfejsach.

        Jeśli już poprawiłeś interfejs, to czytaj dalej.

        Poniżej znajdziesz przykład parametryzowanej metody 'returnT(T t)'.
        Do tej pory w metodach używałeś tylko typów generycznych klasy w której się znajdują (np getter do pola typu T
        z zadania 2).
        Istnieje jednak możliwość deklarowania generyków dla pojedynczej metody.
        Robimy to podobnie jak w przypadku klas -> w nawiasach ostrych podajemy nazwę naszego typu.
        Nasz zapis '<T>' musi pojawić się w deklaracji metody zaraz przed typem zwrotnym.

        Dobrze. Posiadasz już wiedzę na temat ograniczeń i definicji generyków w metodzie.
        Użyj tej wiedzy, by finalnie naprawić metodę 'klonujWokalistę'.

        Co jeszcze nie działa?

        Nasza metoda przyjmuje dowonle obiekty które są Klonowable, nawet jeśli nie są wokalistami, i to jest problem.
        'klonujWokalistę' powinno przyjmować Wokalistów którzy są Klonowable.
        Aby narzucić więcej niż jedno ograniczenie, jak to robiłeś do tej pory, musisz użyć symbolu '&'.
        Przykładowo: <T extends Object & Serializable>

        */
    }

    private static <T> T returnT(T t) {
        // T type is available only in this method
        System.out.println(t);
        return t;
    }
}