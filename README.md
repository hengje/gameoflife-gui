Klon og installer:

```
    git clone git@github.com:hengje/gameoflife-gui.git
    cd gameoflife-gui
    mvn install
```

Legg til følgende avhengighet i din pom.xml:

```xml
   <dependency>
        <groupId>no.finntech.kata.gameoflife</groupId>
        <artifactId>gui</artifactId>
        <version>0.1-SNAPSHOT</version>
    </dependency>
```


Start GUI:

```java
    GameOfLife gameOfLife = new MyGameOfLifeImplementation();
    boolean[][] initialWorld = no.finntech.kata.gameoflife.gui.Worlds.trafficCirle();
    new no.finntech.kata.gameoflife.gui.Gui(gameOfLife, initialWorld).display();
```
