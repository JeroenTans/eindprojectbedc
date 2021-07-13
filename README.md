# Welkom bij Locals for locals!
De volgende onderwerpen worden behandeld:
-   Intro
-   Hoe start ik deze applicatie op
-   Standaard accounts
-   Waar staat alles
-   JSN en endpoints
-   Hoe werkt de applicatie

##Intro
Locals for locals is een applicatie waarin je de stad waarin jij woont kan herontdekken.
Dit doe je door middel van de kennis van de mede gebruikers van de applicatie.
Iedereen heeft wel een plekje in zijn/haar stad waar weinig mensen iets vanaf weten, deze applicatie geeft jullie de mogelijkheid deze plekjes met elkaar te delen of te ruilen.
Je ruilt dus jouw geheim voor iemand anders zijn geheim.
Voor het versturen van de tip heb je de mogelijkheid om de zichtbaarheid van deze tip vast te stellen, wil je dat de tip voor iedereen beschikbaar is kies dan publiek, zo niet privé.

## Hoe start ik deze applicatie op
Je kan in de installatie handleiding stap voor stap lezen hoe je de juiste programma's download. Lees dit goed door want in deze handleiding zie je ook hoe je de juiste database opent en hoe je dit instelt in je back end.
Zodra dit allen is gebeurd en je hebt zowel de back als de front end geopend in IntelliJ en Webstorm moet je eerst de back end runnen door op het groene driehoekje rechts boven te klikken. Hierna moet je in je webstorm terminal **npm install** typen, als dit juist geinstalleerd is moet je **npm start** in de terminal typen(Zie afbeeldingen hiervan in de installatie handleiding).
Stel dat je weet hoe dit allen werkt heb ik hier een korte samenvatting:

-   Open een nieuwe database en noem deze: tip
-   Open in IntelliJ het appllications.properties bestand onder de recources map en verander het wachtwoord naar het het wachtwoord wat jij hebt ingesteld bij het dowloaden van de PostgreSQL database
-   Run de back end applicatie, deze applicatie heet: EindprojectbedcApplication
-   Schrijf in de terminal van Webstorm **npm install**
-   Schrijf in de terminal van Webstorm **npm start**

En voila, Laten we beginnen!

##Standaard accounts
Ik ben zo vrij geweest een aantal accounts aan te maken.
Deze accounts zijn zo ingesteld dat ze al in gebruik zijn, zo heb je bijvoorbeeld een aantal prive tips en publieke tips er tussen staan.
Ook zit je al in een group, je kan natuurlijk in een nieuwe groep gaan, deze bevat alleen nog geen tips. achter het @ staat of het een **user** account is of een **admin** account en het wachtwoord voor alle accounts is: **wachtwoord**.
De accounts zijn:
-   **nova@user, nova@admin**
-   **malou@user, malou@admin**
-   **rein@user, rein@admin**

##Waar staat alles
De mappenstructuur waar ik gebruik van heb gemaakt zijn vooral de: Models, Controllers, Service laag en de Repository Laag
-   In de model laag worden de objecten verklaard, welke variabelen hebben ze etc
-   In de Controllers komt de informatie binnen, In deze laag maak ik gebruik van Methodes die ik in de service laag heb geschreven
-   In de service laag maak ik weer methodes die gebruik maken van de Repository's die ik heb geschreven. 
-   De repository's maken gebruik van de JPA repository, hierin defineer ik van welk model ze gebruik moeten maken. 

###Config
Hierin zal je de Spring security configuration vinden en de corsfilter.

###Controllers
In de controllers kan je alle API end points vinden.
Dit zijn de API's die ik met de front end heb geconnect.

###Exeption
Hierin zal je verschillende expetions vinden die ik heb gebruikt om een bepaalt probleem te kunnen aanduiden.

###filter
Bevat de JwtRequestFilter class

###Model
In deze laag defineer ik al mijn classes en zet ik de variabelen

###Payload
Hierin vind je het Authenticatie request en response, in de response heb ik gedefineerd dat het JWT token, de username, de authority en de groepnaam terug worden gestuurd. 

###Repository
In deze laag word er gebruik gemaakt van de JPA repository, ik heb verschillende methodes m.b.h hiervan samengesteld

###Request
Ik heb een reviewRequest aangemaakt waar ik gebruik van maak in de Review Service laag

###Service
In deze laag het ik van elk model ene Interface en een classe die deze implementeerd gemaakt. Je kan de Interface als een soort inhoudsopgave van de classe zien. 

##Hoe werkt de applicatie.
###Stap één.
Als je een nieuw account wilt aanmaken kan je dat op deze pagina doen. Na het maken van een nieuw account word je automatisch naar de login pagina doorverwezen.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/registreerScherm.png)

###Stap twee
Hier kan je inloggen, ik heb als voorbeeld het user-account van Nova gebruikt.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/InlogScherm.png)

###Stap drie
Helemaal links staan een aantal standaard tips, deze zijn er alvast in gezet door de admin en zullen bij
iedere user te zien zijn. Zodra je op meer lezen klikt zal de tip vergroot worden en heb je de
mogelijkheid reviews te lezen of te schrijven (Hier zie je later een voorbeeld van). In het midden heb je
privé tips die alleen voor jou zichtbaar zijn en rechts heb je de publieke tips. De publieke tips zijn door andere
gebruikers gemaakt maar zijn voor iedereen zichtbaar. Links onderin is je profiel pagina waar je naam te
vinden is, je doorverwezen kan worden naar de Maak tip pagina of een pop up kan triggeren waarin het
concept uitgelegd word.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/OverzichtScherm.png)

###Stap vier
De volgende pagina is de Maak tips pagina. Hierin kan je rechts een tip aanmaken door een image te
uploaden, adres in te vullen, omschrijving te maken en te kiezen of het een prive of publieke tip word.
Het idee is dat de tip die jij maakt gelinkt word aan een tip die een andere gebruiker heeft gemaakt en jij
dus de tip van de andere gebruiker ontvangt en visa versa.
Links kan je jouw ontvangen tips dus zien.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/maakTipsScherm.png)

###Stap vijf
Op de verstuur pagina zal je al de tips vinden die jij hebt verstuurd, links de publieke en rechts de privé.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/verstuurdeTips.png)

###Stap zes
De laatste user pagina is de group pagina. Hier kan je een groepnaam opgeven waar jij dan aan gaat
deelnemen (Helemaal rechts. In deze groep kunnen meerdere mensen deelnemen. De tips die hier
worden geplaatst zijn alleen zichtbaar voor de groep. Ik heb jullie bij default ingedeeld in de groep Tipsy
(snap je? Tip(sy)). Ook hier kan je weer reviews schrijven, je kan reviews schrijven in een groep zien als
chatten met elkaar. Natuurlijk moet je die groep tips ook kunnen toevoegen, dat kan in het midden.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/groepScherm.png)
Dit is wat er gebeurd als je op lees meer klikt.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/vergrootteTip.png)
Hier zie je een gesprek, klik op lees reviews.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/reviewGesprek.png)

###Stap één/admin
Ik heb in dit voorbeeld het admin account van nova gebruikt.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/adminLogin.png)

###Stap twee/admin
Als je met een admin account inlogt dan word je naar een andere pagina verwezen. Op deze pagina kan
je users deleten, admin maken van users, reviews deleten, tips deleten maar natuurlijk ook de tips die
gebruikers maken aan elkaar linken. Belangrijk is dat de username niet overeen komt, aangezien je de
user die de tip heeft gemaakt niet dezelfde tip wilt terug geven. Je linkt de tips aan elkaar door in het
middelste scherm de id's van de tips die je aan elkaar wilt linken in te voeren, hierna klik je op: link de tips.
Links boven zie je de prive tips en rechts boven de publieke tips.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/adminScherm%20.png)

###Stap drie/admin
Hier worden de standaard tips gemaakt, dit zullen tips zoals het Anne Frank huis zijn. De admin is de enige die deze tips kan maken.
![alt text](https://raw.githubusercontent.com/JeroenTans/eindprojectFEC/main/src/images/adminStandaardTip.png)

##Veel plezier!!
Bij vragen of opmerkingen kan je altijd een email sturen naar: jeroentans1@gmail.com of via een andere manier die bekend is bij jou.


