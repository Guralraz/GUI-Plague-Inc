package com.model.singletons;

import com.model.abstractclasses.AbstractRegion;
import com.model.enums.*;

public class Virus {
    private static volatile Virus INSTANCE;
    private volatile Virulence virulence;
    private volatile VirulenceRateAridClimate virulenceRateAridClimate;
    private volatile VirulenceRateWetClimate virulenceRateWetClimate;
    private volatile VirulenceRateRural virulenceRateRural;
    private volatile VirulenceRateUrban virulenceRateUrban;
    private volatile GlobalTime globalTime = GlobalTime.getInstance();

    private Virus() {
        this.virulence = Virulence.LOWEST;
    }

    public Virulence getVirulence() {
        return virulence;
    }

    public void setVirulence(Virulence virulence) {
        this.virulence = virulence;
    }

    public void infect(AbstractRegion abstractRegion) {
        switch (virulence) {
            case LOWEST -> {
                switch (abstractRegion.getClimate()) {
                    case ARID -> {
                        switch (virulenceRateAridClimate) {
                            case LOW -> {
                                switch (abstractRegion.getHealthCareLevel()) {
                                    case LOW -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(50);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(100);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(100);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(300);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case MID -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(20);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(50);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(50);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(150);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case HIGH -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(5);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(15);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(10);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(30);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            case HIGH -> {
                                switch (abstractRegion.getHealthCareLevel()) {
                                    case LOW -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(100);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(300);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(200);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(600);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case MID -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(50);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(150);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(100);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(300);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    case HIGH -> {
                                        switch (abstractRegion.getUrbanizationLevel()) {
                                            case RURAL -> {
                                                switch (virulenceRateRural) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(1);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(3);
                                                    }
                                                }
                                            }
                                            case URBAN -> {
                                                switch (virulenceRateUrban) {
                                                    case LOW -> {
                                                        abstractRegion.setInfections(3);
                                                    }
                                                    case HIGH -> {
                                                        abstractRegion.setInfections(9);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case WET -> {
                    }
                }
            }
            case LOWER -> {
            }
            case LOW -> {
            }
            case MEDIUM -> {
            }
            case HIGH -> {
            }
            case HIGHER -> {
            }
            case HIGHEST -> {
            }
        }
    }

    public static Virus getInstance() {
        if (INSTANCE == null) {
            synchronized (Virus.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Virus();
                }
            }
        }
        return INSTANCE;
    }
}