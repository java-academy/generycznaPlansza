package workshop;

/**
 * Podsumowanie Zadania1:
 *
 * Jak widziałeś, używanie generyków pozwala kompilatorowi na sprawdzanie elementów przy dodawaniu
 * zmniejszając szanse na ClassCastException, oraz redukuje konieczność ręcznego rzutowania.
 *
 * Inną zaletą generyków jest ograniczenie powtórzeń kodu.
 * Bez generyków byliśmy zmuszeni do duplikowania kodu dla różnych typów, lub używania Object jako typu
 * referencyjnego narażając się na CCE.
 *
 * Podsumowanie Zadania2:
 *
 * Napisałeś kilka parametryzowanych klas i metod.
 * Dowiedziałeś się również, że nie możesz stworzyć tablicy typu generycznego, ponieważ
 * w Runtimie nie możesz dokładnie określić typu... Ale w sumie dlaczego?
 *
 * Czas na wymazywanie typów.
 *
 * @author Wojciech Makiela
 */
public class Zadanie3 {

    public static void main(String[] args) {
        /*
        W ramach pierwszego zadania napisałeś kod działający w Javie 1.4.
        Po przekopiowaniu do tego repo (gdzie pracujemy na nowszej Javie) kod dalej działał.
        To dzięki kompatybilności wstecznej.

        Żeby skutecznie pracować z generykami należy zrozumieć, że informacja o typach parametryzowanych jest
        dostępna tylko dla kompilatora - wirtualna maszyna Javy nie ma dostępu do tej informacji.
        Innymi słowy, wymazywanie typów (ang. "type erasure") oznacza, że informacje o generykach nie są dostępne
        podczas działania programu (Runtime), ponieważ zostały usunięte podczas kompilacji.

        Jaki jest sens wymazywania typów?
        Odpowiedź jest prosta - by zachować kompatybilność wsteczną.
        Przed wprowadzeniem generyków kolekcje używały obiektów (Object). Po wprowadzeniu generyków pojawił się problem.
        Potrzebne było rozwiązanie, które po skompilowaniu (w postaci bytecodu) będzie wyglądać tak samo
        zarówno z, jak i bez generyków.
        Kod maszynowy powstały w wyniku kompilacji kodu parametryzowanego będzie wyglądał tak, jakby generyki
        nie istniały.

        Jak to działa?
            Kompilator zamienia typy parametryzowane na obiekty (Object).
            Zamienia typy ograniczone (o nich później) na pierwszą klasę ograniczającą.
            Dodaje rzutowanie przy wyciąganiu elementów parametryzowanego typu.

            Na przykładzie:
                List l = new ArrayList();
                List<String> l = new ArrayList<String>();
            Niezależnie której linijki użyjesz, bytecode będzie taki sam;


        PS.

            List l = new ArrayList();

        Mimo tego, że taki kod się skompiluje, to prawdopodobnie dostaniesz ostrzeżenie od kompilatora.
        Jest to spowodowane utratą dodatkowych sprawdzeń podczas kompilacji które dają nam generyki.

        Do zapamiętania: mimo tego że dzięki kompatybilności wstecznej możemy pisać z użyciem typów surowych
        (czyli domyślnego Object), to nie powinniśmy tego używać, ponieważ jest to zła praktyka.
        */
    }
}
