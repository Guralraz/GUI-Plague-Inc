package com.model.singletons;

import com.model.interfaces.Region;
import com.model.singletons.regions.*;

public class GlobalGameState {
    private static volatile GlobalGameState INSTANCE;
    private volatile Integer globalInfections;
    private Balkans balkans = Balkans.getInstance();
    private Baltics baltics = Baltics.getInstance();
    private CentralEurope centralEurope = CentralEurope.getInstance();
    private EasternEurope easternEurope = EasternEurope.getInstance();
    private France france = France.getInstance();
    private Germany germany = Germany.getInstance();
    private Greece greece = Greece.getInstance();
    private Iberia iberia = Iberia.getInstance();
    private Ireland ireland = Ireland.getInstance();
    private UK uk = UK.getInstance();
    private Denmark denmark = Denmark.getInstance();
    private NorthernEurope northernEurope = NorthernEurope.getInstance();
    private Poland poland = Poland.getInstance();
    private SouthEasternEurope southEasternEurope = SouthEasternEurope.getInstance();
    private Switzerland switzerland = Switzerland.getInstance();
    private Turkiye turkiye = Turkiye.getInstance();
    private WesternEurope westernEurope = WesternEurope.getInstance();
    private Virus virus = Virus.getInstance();
    private Boolean gameStarted;

    private GlobalGameState() {
        this.globalInfections = 0;
        this.gameStarted = false;
    }

    public Integer getGlobalInfections() {
        return globalInfections;
    }

    public synchronized void addOnePoint(Region region) {
        switch (region.getClass().getSimpleName()) {
            case ("France") -> {
                virus.infect(france);
                this.globalInfections += this.france.getInfections();
            }
            case ("Greece") -> {
                virus.infect(greece);
                this.globalInfections += this.greece.getInfections();
            }
            case ("Iberia") -> {
                virus.infect(ireland);
                this.globalInfections += this.iberia.getInfections();
            }
            case ("Poland") -> {
                virus.infect(poland);
                this.globalInfections += this.poland.getInfections();
            }
            case ("Balkans") -> {
                virus.infect(balkans);
                this.globalInfections += this.balkans.getInfections();
            }
            case ("Baltics") -> {
                virus.infect(baltics);
                this.globalInfections += this.baltics.getInfections();
            }
            case ("Germany") -> {
                virus.infect(germany);
                this.globalInfections += this.germany.getInfections();
            }
            case ("Turkiye") -> {
                virus.infect(turkiye);
                this.globalInfections += this.turkiye.getInfections();
            }
            case ("Switzerland") -> {
                virus.infect(switzerland);
                this.globalInfections += this.switzerland.getInfections();
            }
            case ("CentralEurope") -> {
                virus.infect(centralEurope);
                this.globalInfections += this.centralEurope.getInfections();
            }
            case ("EasternEurope") -> {
                virus.infect(easternEurope);
                this.globalInfections += this.easternEurope.getInfections();
            }
            case ("Ireland") -> {
                virus.infect(ireland);
                this.globalInfections += this.ireland.getInfections();
            }
            case ("UK") -> {
                virus.infect(uk);
                this.globalInfections += this.uk.getInfections();
            }
            case ("Denmark") -> {
                this.globalInfections += this.denmark.getInfections();

            }
            case ("WesternEurope") -> {
                virus.infect(westernEurope);
                this.globalInfections += this.westernEurope.getInfections();
            }
            case ("NorthernEurope") -> {
                virus.infect(northernEurope);
                this.globalInfections += this.northernEurope.getInfections();
            }
            case ("SouthEasternEurope") -> {
                virus.infect(southEasternEurope);
                this.globalInfections += this.southEasternEurope.getInfections();
            }
            default -> throw new IllegalStateException("Unexpected value: " + region);
        }
    }

    public void setGameStarted() {
        this.gameStarted = true;
    }

    public static GlobalGameState getInstance() {
        if (INSTANCE == null) {
            synchronized (GlobalGameState.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GlobalGameState();
                }
            }
        }
        return INSTANCE;
    }
}
