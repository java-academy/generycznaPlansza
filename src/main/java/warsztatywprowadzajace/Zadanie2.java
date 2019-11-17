package warsztatywprowadzajace;

/**
 * <h1>Generyki!!!</h1>
 * <p>Poniżej masz klasę Zadanie2. Ugenerycznij ją!</p>
 * Chcę aby przechowywała ona 2 zmienne. Jedną typu T, a drugą typu S.
 * Aktualnie przyjmuje tylko jeden typ parametryzowany. Napraw to!
 * <p>
 * Możesz zdefiniować dodatkowe typy dopisując je po przecinku w nawiasach ostrokątnych ('<>').
 *
 * @author Wojciech Makiela
 */
public class Zadanie2<T> {

    // TODO - pola typu S
    final T poleTypuT;


    // TODO - popraw konstruktor. Ma przyjmować 2 zmienne - typu T i S
    public Zadanie2(T zmiennaTypuT) {
        this.poleTypuT = zmiennaTypuT;
    }

    /*
    Jeśli skończyłeś, to odpal testy (klasa Zadanie2Test). Były zakomentowane, co by się kompilowało.

    if (testy.przechodzą()) continue;
    else return;

    No to co. Wiesz już co zrobić, twoje klasy były parametryzowane. Nice.
    Klasa Zadanie2 łączy parę obiektów pod swoimi skrzydłami. Fajnie...

    ...Ale po co?

    Wyobraźmy sobie, że piszesz grę w kółko i krzyżyk (na przykład).
    Teraz wydaje Ci się, że sparowanie obiektów Gracza i Symbolu może być przydatne, a nie chcesz
    żeby Gracz miał Symbol (w imię Single Responsibility Principle).
    A więc robisz klasę ParaGraczSymbol i wszystko fajnie działa.
    ...
    Teraz wydaje Ci się, że chcesz mieć parę obiektów Gracze i GraKiK.
    A więc robisz klasę ParaGraczeGraKiK i wszystko fajnie działa.
    ...
    Teraz wydaje Ci się... wiesz do czego dążę.

    Tworzenie wielu klas z tą samą funkcjonalnością, ale innymi polami prowadzi do brzydkiego,
    zbugowanego kodu.

    Na szczęście, dzięki mocy generyków, możesz stworzyć jedną klasę Para<T, S> która zrobi wszystko czego Ci trzeba!

    */
}


class Wór {

    /*
    Następne zadanie - klasa Wór - powtórka z tworzenia klas generycznych. 5 minut roboty :P

    Nasz worek powinien zawierać 3 zmienne.
    2 parametryzowane (generyczne) o nazwach 'Pierwszy' i 'Drugi', i jedną listę stringów.
    Nie musisz użyć dokładnie tych nazw, ale testy zakładają użycie getterów po takie właśnie
    zmienne, więc możesz użyć IDE do automatycznej generacji kodu.

    Testy znajdziesz w klasie WórTest.

    ...

    No i dobra. Było kodzone, teraz trochę teorii.
    Wrócimy na moment do klasy Zadanie2. Dodaj w jej konstruktorze taką linijkę:

        T[] ts = new T[10];

    Otrzymasz błąd kompilacji. Lekcja na dziś - nie da się stworzyć tablicy typu generycznego.
    Dlaczego?

    Każdy obiekt w Javie zna swoją klasę, którą można podejrzeć w trakcie działania aplikacji (dalej zwanym Runtime)
    za pomocą metody '.getClass()'. Tablice różnych typów odpowiadają różnym klasom. Po ludzku:

        mojaTablicaIntów.getClass() != mojaTablicaStringów.getClass(); // true

    Ale skąd obiekt wie, jaką klasę reprezentuje? Ta informacja jest dostarczana w momencie tworzenia obiektu.
    To samo tyczy się tablic (wszak tablice są obiektami). Co za tym idzie, podczas tworzenia tablicy musisz
    dokładnie wyznaczyć jakie elementy będą w niej przechowywane.

    I tutaj pojawia się problem. Informacje o T tracone są w trakcie kompilacji (o wymazywaniu typów w następnym zadaniu).
    Próbując w Runtimie stworzyć tablicę (T[]) nie wiesz czym tak naprawdę jest 'T', a więc nie jesteś w stanie
    dostarczyć wymaganej informacji o klasie którą reprezentować ma nasza tablica.

    Ciekawostka:
    Generyki mają konwencję nazewnictwa!
        E - Element
        K - Key
        N - Number
        T - Type
        V - Value
        S,U,V etc. - drugi, trzeci itd element po 'T'.

    Dobra rada - nie stosujcie się do niej - przynajmniej nie podczas pisania.
    Kiedy pojawia się wiele generyków w wielu klasach, i wszędzie mają te same (jednoliterowe) nazwy reprezentujące
    różne rzeczy, łatwo się pogubić.
    Polecam (przynajmniej na czas pisania kodu - potem można zmienić) używać opisowych nazw.

     */

}

