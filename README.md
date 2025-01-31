<h1>Arbetsprov-digg</h1>
<p>
Arbetsprov-digg är en fullstack applikation som består av en frontend och en backend som är containeriserad med Docker, vilket gör det lättare att starta upp applikationen utan att ladad ner alla beroenden. Projektets frontend är byggt med Vue.js som drivs av Vite.js för att ge en visuell bild av alla användares information på ett snyggt och simpelt sätt. Projektets backend är byggt med Java där vi använder ramverket Quarkus för att hantera användarinformation genom att skapa, updatera, radera och visa användare.
</p>
<h2 id=innehållsförteckning>Innehållsförteckning</h2>
<ul>
  <li><a href="#projektets-struktur">Projektets Sturktur</a></li>
  <li><a href="#förutsättningar">Förutsättningar</a></li>
  <li><a href="#installation-och-startup">Installation och startup</a></li>
  <ul>
    <li><a href="startup-docker">Köra applikationen med Docker</a></li>
    <li><a href="startup-local">Köra applikationen lokaltr</a></li>
  </ul>
</ul>
<h2 id=projektets-struktur>Projektets struktur</h2>
<p>Applikationen är uppdelad i två delar:</p>
<ol>
  <li><strong>Frontend</strong>: Applikationen hanterar användargränssnittet i webbläsaren. Den byggs ihop med Vue.js och hanteras av <strong>Vite</strong> i produktionsmiljö.</li>
  <li><strong>Backend</strong>: Applikationen hanterar datalogik och API som hanteras av Quarkus ramverket till Java. Denna applikation hanterar alla anrop för att skapa, uppdatera, radera och visa användare.</li>
</ol>
<h4>Projektets flöde är uppbyggt på att man kör antingen projektet lokalt eller Docker. Vi använder en docker compose fil för att starta och bygga igång båda applikationerna.</h4>

<h2 id="förutsättningar">Förutsättningar</h2>
<p>För att kunna använda applikationen behöver du följande:</p>
<ul>
  <li><strong>Docker</strong>: Installera docker <a href="https://docs.docker.com/get-started/get-docker/">Get Docker</a></li>
  <li><strong>Detta projekt från Github</strong>: Klona hem projektet <a href="https://github.com/KrQnan/Arbetsprov-digg.git">DIGG-arbetsprov</a></li>
  <li><strong>Node.js och npm</strong>: Installera Node.js <a href="https://nodejs.org/en">Get Nodejs</a></li>
  <li><strong>Java 23 och Quarkus</strong>: Installera Java SDK <a href="https://www.oracle.com/java/technologies/downloads/">Get JAVA SDK </a> och Quarkus <a href="https://quarkus.io/">Get Quarkus</a></li>
  <li><strong></strong></li>
</ul>
<h2 id="installation-och-startup">Installation och startup</h2>
<h3 id="startup-docker">Köra applikationen med Docker</h3>
<h3 id="startup-local">Köra applikationen Lokalt</h3>

