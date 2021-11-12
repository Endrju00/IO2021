# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. 

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1), [UC2](#uc2))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2), [UC2](#uc2))
4. [Kupujący](#ac2) przekazuje należność [Sprzedającemu](#ac1). ([UC2](#uc2))
5. [Sprzedający](#ac1) przekazuje produkt [Kupującemu](#ac2). ([UC3](#uc3))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC3](#uc2): Przekazanie należności
* [UC4](#uc3): Przekazanie przedmiotu 

[Kupujący](#ac2)
* [UC2](#uc2): Wygranie aukcji
* [UC3](#uc2): Przekazanie należności 
* [UC4](#uc3): Przekazanie przedmiotu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Wygranie aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**

1. System informuje o rozpoczęciu aukcji
2. System informuje o aktualnej kwocie za przedmiot
3. [Kupujący](#ac2) składa ofertę 
4. System oczekuje na przebicie aktualnej oferty
5. System akceptuje aktualną ofertę
6. [Kupujący](#ac2) wygrywa akcje

**Scenariusze alternatywne:** 

3.A. [Kupujący](#ac2) składa ofertę niezgodą z [regułą](#br1) 
* 3.A.1. Oferta zostaje odrzucona

4.A. Oferta zostaje przebita
* 4.A.1. Powrót do kroku 2.

4.B Oferta nie zostaje przebita
* 4.B.1. System odczekuje 5 sekund po czym kontynuuje postępowanie

---

<a id="uc3"></a>
### UC3: Przekazanie należności

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**

1. [Kupujący](#ac2) zgłasza chęć uregulowania należności
2. System informuje o sposobach płatności
3. [Kupujący](#ac2) wybiera sposób płatności
4. [Kupujący](#ac2) zostaje przekierowany na strone zewnętrznej metody płatności
5. [Kupujący](#ac2) dokonuje płatności
6. System weryfikuje status płatności
7. System informuje o pomyślnym zakończeniu płatności

**Scenariusze alternatywne:** 

3.A. [Kupujący](#ac2) wybiera płatność gotówką
* 3.A.1. [Kupujący](#ac2) dokonuje płatności przy odbiorze przedmiotu
5.A [Kupujący](#ac2) nie dokonuje płatności
* 5.A.1. [Kupujący](#ac2) ma tydzień na uregulowanie płatności w systemie
* 5.A.2. W przypadku nie dokonania płatności w terminie dodatkowym

---

<a id="uc4"></a>
### UC4: Przekazanie przedmiotu

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza chęc odebrania przedmiotu
2. System prosi o wybranie terminu odbioru przedmiotu z listy dostępnych terminów
3. [Kupujący](#ac2) wybiera termin odbioru
4. System zapisuje podany termin
5. [Kupujący](#ac2) okazuje się w umówionym terminie
6. [Kupujący](#ac2) potwierdza swoją tożsamość
7. [Sprzedający](#ac1) przekazuje przedmiot [Kupującemu](#ac2)
8. [Sprzedający](#ac1) wprowadza status przekazania przedmiotu
9. System informuje o zakończonym statusie przekazania przedmiotu

**Scenariusze alternatywne:** 

5.A. [Kupujący](#ac2) nie okazuje się w umówionym terminie
* 5.A.1. [Kupujący](#ac2) ma 30 dni na ustalenie nowego terminu
* 5.A.2. [Kupujący](#ac2) zostanie obciążony opłatą za dodatkowe magazynowanie przedmiotu

6.A. [Kupujący](#ac2) nie posiada dokumentu potwierdzającego jego tożsamość
* 6.A.1. [Kupujący](#ac2) ma 30 dni na dostarczenie takiego dokumentu oraz ustalenie nowego terminu
* 6.A.2. [Kupujący](#ac2) zostanie obciążony opłatą za dodatkowe magazynowanie przedmiotu

6.B [Kupujący](#ac2) podczas wybierania metody płatności wybrał płatność gotówką
* 6.B.1 [Kupujący](#ac2) dodatkowo dokonuje płatności

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja  | Produkt | ... |
| ------------------------------------------------- | ------- | ------- | --- |
| UC1: Wystawienie produktu na aukcję               |    C    |    C    | ... |
| UC2: Wygranie aukcji                              |    U    |    R    | ... |
| UC3: Przekazanie należności                       |    U    |    R    | ... |
| UC4: Przekazanie przedmiotu                       |    D    |   U, D  | ... |


