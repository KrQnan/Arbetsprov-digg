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
<ul>
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
</ul>
<h2 id="installation-och-startup">Installation och startup</h2>
<h3 id="startup-docker">Köra applikationen med Docker</h3>
<h4>Klona projektet från Github<h4>
<p>Genom att köra följande kommando i valfri terminal så kommer du klona hem projektet till din enhet</p>
<pre class="language-bash">
  <code class="prism language-bash">
    <span class="token function">git</span> clone https://github.com/{ditt github namn}/Arbetsprov-digg.git
    <span class="token function">cd</span> Arbetsprov-digg
  </code>
</pre>
<h4 id="bygg-och-starta-applikationen-med-docker-compose">2. Bygg och starta applikationen med Docker Compose</h4>
<p>Med följande kommando så kan vi bygga och köra båda applikationerna samtidigt.</p>
<pre class=" language-bash">
  <code class="prism  language-bash">docker-compose up --build</code>
</pre>
<ul>
  <li>Detta kommando kommer att bygga frontend och backend från grunden.</li>
  <li>Frontend tjänsten kommer köras på <a href="http://localhost:3030">http://localhost:3030</a>.</li>
  <li>Backend tjänsten kommer köras på <a href="http://localhost:8080">http://localhost:8080/</a>.</li>
</ul>
<h4 id="kontrollera-att-applikationen-körs">3. Kontrollera att applikationen körs</h4>
<p>När applikationen har startat kan du öppna din webbläsare och gå till:</p>
<ul>
  <li><strong>Frontend:</strong> <a href="http://localhost">http://localhost:3030</a></li>
  <li><strong>Backend:</strong> <a href="http://localhost:8080">http://localhost:8080</a></li>
</ul>
<h4 id="stoppa-applikationen">Stoppa applikationen</h4>
<p>För att stänga av applikationen, tryck <code>CTRL + C</code> i terminalen där Docker Compose körs. Du kan också stänga ner alla Docker-containrar med:</p>
<pre class=" language-bash">
  <code class="prism  language-bash">docker-compose down</code>
</pre>
<h3 id="startup-local">Köra applikationen lokalt</h3>
<p>Om du vill köra frontend och backend lokalt så kan du följa följande steg:</p>
<h4 id="backend">Backend</h4>
<ul>
  <li>
    <p>Gå till backend-katalogen:</p>
    <pre class=" language-bash">
      <code class="prism  language-bash">
        <span class="token function">cd</span> Arbetsprov-quarkus
      </code>
    </pre>
  </li>
  <li>
    <p>Bygg och kör backend med Maven (du måste ha Java, Maven och Quarkus installerat):</p>
    <pre class=" language-bash">
      <code class="prism  language-bash">./mvn clean quarkus:dev</code>
    </pre>
  </li>
</ul>
<p>Backend kommer nu att köra på <a href="http://localhost:8080/">http://localhost:8080/</a>.</p>
<h4 id="frontend">Frontend</h4>
<ul>
  <li>
    <p>Gå till frontend-katalogen:</p>
    <pre class=" language-bash">
      <code class="prism  language-bash"><span class="token function">cd</span> Arbetsprov-vue</code>
    </pre>
  </li>
  <li>
    <p>Installera beroenden (du måste ha Node.js och npm installerat):</p>
    <pre class=" language-bash"><code class="prism  language-bash"><span class="token function">npm</span> <span class="token function">install</span></code>
    </pre>
  </li>
  <li>
    <p>Starta utvecklarmiljön</p>
    <pre class=" language-bash">
      <code class="prism  language-bash"><span class="token function">npm</span> run dev</code>
    </pre>
  </li>
</ul>
<p>Frontend kommer nu att köra på <a href="http://localhost:3000">http://localhost:3000</a>.</p>
<h2 id="testning">Testning</h2>
<h3 id="backend-enhetstester">Backend-enhetstester</h3>
<p>Enhetstesterna för backend verifierar att backenden fungerar som förväntat. För att köra testerna, gå till backend-katalogen och kör:</p>
<pre class=" language-bash">
  <code class="prism  language-bash">./mvn <span class="token function">quarkus:test</span></code>
</pre>
<p>Om alla tester lyckas, kommer du att se meddelandet “BUILD SUCCESS” i terminalen.</p>
<h3 id="enhetstester-som-täcks">Enhetstester som täcks</h3>
<ul>
  <li>Hämta alla användare (GET /digg/user)</li>
  <li>Skapa ny användare (POST /digg/create)</li>
  <li>Uppdatera användare (PUT /digg/update)</li>
  <li>Radera användare (DELETE /digg/delete)</li>
</ul>
<h2 id="api-dokumentation">API-dokumentation</h2>
<p>Backend tillhandahåller ett REST API som gör det möjligt att interagera med användardata. Här är en översikt av de API-slutpunkter som finns:</p>
<ul>
<li><strong>GET /digg/user</strong> - Hämtar alla användare.</li>
<li><strong>POST /digg/creater</strong> - Skapar en ny användare.</li>
<li><strong>PUT /digg/update</strong> - Uppdaterar en befintlig användare baserat på dess id.</li>
<li><strong>DELETE /digg/delete</strong> - Raderar en användare med ett användar id.</li>
</ul>
<h2 id="troubleshoot">Vanliga problem och felsökning</h2>

<h2 id="framtida-förbättringar">Framtida förbättringar</h2>

<h2 id="licens">Licens</h2>

