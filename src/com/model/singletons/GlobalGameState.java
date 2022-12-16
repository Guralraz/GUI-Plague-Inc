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
    private IrelandAndUK irelandAndUK = IrelandAndUK.getInstance();
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
                this.france.addOnePoint();
                this.globalInfections += this.france.getPointsFrance();
            }
            case ("Greece") -> {
                this.greece.addOnePoint();
                this.globalInfections += this.greece.getPointsGreece();
            }
            case ("Iberia") -> {
                this.iberia.addOnePoint();
                this.globalInfections += this.iberia.getPointsIberia();
            }
            case ("Poland") -> {
                this.poland.addOnePoint();
                this.globalInfections += this.poland.getPointsPoland();
            }
            case ("Balkans") -> {
                virus.infect(balkans);
                this.globalInfections += this.balkans.getInfections();
            }
            case ("Baltics") -> {
                this.baltics.addOnePoint();
                this.globalInfections += this.baltics.getPoints();
            }
            case ("Germany") -> {
                this.germany.addOnePoint();
                this.globalInfections += this.germany.getPointsGermany();
            }
            case ("Turkiye") -> {
                this.turkiye.addOnePoint();
                this.globalInfections += this.turkiye.getPointsTurkiye();
            }
            case ("Switzerland") -> {
                this.switzerland.addOnePoint();
                this.globalInfections += this.switzerland.getPointsSwitzerland();
            }
            case ("CentralEurope") -> {
                this.centralEurope.addOnePoint();
                this.globalInfections += this.centralEurope.getPointsCentralEurope();
            }
            case ("EasternEurope") -> {
                this.easternEurope.addOnePoint();
                this.globalInfections += this.easternEurope.getPointsEasternEurope();
            }
            case ("IrelandAndUK") -> {
                this.irelandAndUK.addOnePoint();
                this.globalInfections += this.irelandAndUK.getPointsIrelandUK();
            }
            case ("WesternEurope") -> {
                this.westernEurope.addOnePoint();
                this.globalInfections += this.westernEurope.getPointsWesternEurope();
            }
            case ("NorthernEurope") -> {
                this.northernEurope.addOnePoint();
                this.globalInfections += this.northernEurope.getPointsNorthernEurope();
            }
            case ("SouthEasternEurope") -> {
                this.southEasternEurope.addOnePoint();
                this.globalInfections += this.southEasternEurope.getPointsSouthEasternEurope();
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
