package com.model.services;

import com.model.abstractclasses.AbstractRegion;
import com.model.singletons.regions.*;
import com.view.labels.CountryLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.MessageFormat;
import java.util.*;
import java.util.List;

/* 
 Outline code from:
 https://stackoverflow.com/q/7218309/418556
 */
public class WorldMapArea {

    //TODO create a custom JLabel extending class with a Country field
    private JComponent ui = null;
    CountryLabel output = new CountryLabel();
    public static final int SIZE = 750;
    BufferedImage image;
    Area area;
    ArrayList<Country> shapeList;

    public WorldMapArea() {
        try {
            initUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public final void initUI() throws Exception {
        if (ui != null) {
            return;
        }
        //URL url = new URL("https://i.stack.imgur.com/N4eOn.png");
        image = ImageIO.read(new File("mapa europy.png"));
        area = getOutline(Color.WHITE, image, 12);
        shapeList = separateShapeIntoRegions(area);
        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        output.addMouseMotionListener(new MousePositionListener());
        output.addMouseListener(new MouseClickListener());

        ui.add(output);

        refresh();
    }

    public Area getOutline(Color target, BufferedImage bi, int tolerance) {
        // construct the GeneralPath
        GeneralPath gp = new GeneralPath();

        boolean cont = false;
        for (int xx = 0; xx < bi.getWidth(); xx++) {
            for (int yy = 0; yy < bi.getHeight(); yy++) {
                if (isIncluded(new Color(bi.getRGB(xx, yy)), target, tolerance)) {
                    //if (bi.getRGB(xx,yy)==targetRGB) {
                    if (cont) {
                        gp.lineTo(xx, yy);
                        gp.lineTo(xx, yy + 1);
                        gp.lineTo(xx + 1, yy + 1);
                        gp.lineTo(xx + 1, yy);
                        gp.lineTo(xx, yy);
                    } else {
                        gp.moveTo(xx, yy);
                    }
                    cont = true;
                } else {
                    cont = false;
                }
            }
            cont = false;
        }
        gp.closePath();

        // construct the Area from the GP & return it
        return new Area(gp);
    }

    private static Integer number = 0;
    //    private static Set<Integer> numbers = new HashSet<>();
    private static Map<Country, AbstractRegion> countriesMap = new HashMap<>();
    private static ArrayList<Country> regions = new ArrayList<>();
    private static ArrayList<CountryLabel> labels = new ArrayList<>();


    public static ArrayList<Country> separateShapeIntoRegions(Shape shape) {
        PathIterator pi = shape.getPathIterator(null);
        GeneralPath gp = new GeneralPath();
        while (!pi.isDone()) {
            double[] coords = new double[6];
            int pathSegmentType = pi.currentSegment(coords);
            int windingRule = pi.getWindingRule();
            gp.setWindingRule(windingRule);
            if (pathSegmentType == PathIterator.SEG_MOVETO) {
                gp = new GeneralPath();
                gp.setWindingRule(windingRule);
                gp.moveTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_LINETO) {
                gp.lineTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_QUADTO) {
                gp.quadTo(coords[0], coords[1], coords[2], coords[3]);
            } else if (pathSegmentType == PathIterator.SEG_CUBICTO) {
                gp.curveTo(
                        coords[0], coords[1],
                        coords[2], coords[3],
                        coords[4], coords[5]);
            } else if (pathSegmentType == PathIterator.SEG_CLOSE) {
                gp.closePath();
                regions.add(new Country(number, new Area(gp)));
                //TODO populacja Country country w AbstractRegion
                if (number == 3) {
                    Iceland.getInstance().setCountry(regions.get(3));
                    labels.add(new CountryLabel());
                    labels.get(0).setPrototypeRegion(Iceland.getInstance());
                    labels.get(0).setCountry(regions.get(3));
                } else if (number == 4) {
                    NorthernEurope.getInstance().setCountry(regions.get(4));
                    labels.add(new CountryLabel());
                    labels.get(1).setPrototypeRegion(NorthernEurope.getInstance());
                    labels.get(1).setCountry(regions.get(4));
                } else if (number == 5) {
                    Denmark.getInstance().setCountry(regions.get(5));
                    labels.add(new CountryLabel());
                    labels.get(2).setPrototypeRegion(Denmark.getInstance());
                    labels.get(2).setCountry(regions.get(5));
                } else if (number == 6) {
                    Baltics.getInstance().setCountry(regions.get(6));
                    labels.add(new CountryLabel());
                    labels.get(3).setPrototypeRegion(Baltics.getInstance());
                    labels.get(3).setCountry(regions.get(6));
                } else if (number == 8) {
                    Ireland.getInstance().setCountry(regions.get(8));
                    labels.add(new CountryLabel());
                    labels.get(4).setPrototypeRegion(Ireland.getInstance());
                    labels.get(4).setCountry(regions.get(8));
                } else if (number == 9) {
                    UK.getInstance().setCountry(regions.get(9));
                    labels.add(new CountryLabel());
                    labels.get(5).setPrototypeRegion(UK.getInstance());
                    labels.get(5).setCountry(regions.get(9));
                } else if (number == 10) {
                    Poland.getInstance().setCountry(regions.get(10));
                    labels.add(new CountryLabel());
                    labels.get(6).setPrototypeRegion(Poland.getInstance());
                    labels.get(6).setCountry(regions.get(10));
                } else if (number == 11) {
                    WesternEurope.getInstance().setCountry(regions.get(11));
                    labels.add(new CountryLabel());
                    labels.get(7).setPrototypeRegion(WesternEurope.getInstance());
                    labels.get(7).setCountry(regions.get(11));
                } else if (number == 14) {
                    Germany.getInstance().setCountry(regions.get(14));
                    labels.add(new CountryLabel());
                    labels.get(8).setPrototypeRegion(Germany.getInstance());
                    labels.get(8).setCountry(regions.get(14));
                } else if (number == 15) {
                    EasternEurope.getInstance().setCountry(regions.get(15));
                    labels.add(new CountryLabel());
                    labels.get(9).setPrototypeRegion(EasternEurope.getInstance());
                    labels.get(9).setCountry(regions.get(15));
                } else if (number == 16) {
                    CentralEurope.getInstance().setCountry(regions.get(16));
                    labels.add(new CountryLabel());
                    labels.get(10).setPrototypeRegion(CentralEurope.getInstance());
                    labels.get(10).setCountry(regions.get(16));
                } else if (number == 17) {
                    Switzerland.getInstance().setCountry(regions.get(17));
                    labels.add(new CountryLabel());
                    labels.get(11).setPrototypeRegion(Switzerland.getInstance());
                    labels.get(11).setCountry(regions.get(17));
                } else if (number == 18) {
                    France.getInstance().setCountry(regions.get(18));
                    labels.add(new CountryLabel());
                    labels.get(12).setPrototypeRegion(France.getInstance());
                    labels.get(12).setCountry(regions.get(18));
                } else if (number == 19) {
                    SouthEasternEurope.getInstance().setCountry(regions.get(19));
                    labels.add(new CountryLabel());
                    labels.get(13).setPrototypeRegion(SouthEasternEurope.getInstance());
                    labels.get(13).setCountry(regions.get(19));
                } else if (number == 20) {
                    Balkans.getInstance().setCountry(regions.get(20));
                    labels.add(new CountryLabel());
                    labels.get(14).setPrototypeRegion(Balkans.getInstance());
                    labels.get(14).setCountry(regions.get(20));
                } else if (number == 22) {
                    Turkiye.getInstance().setCountry(regions.get(22));
                    labels.add(new CountryLabel());
                    labels.get(15).setPrototypeRegion(Turkiye.getInstance());
                    labels.get(15).setCountry(regions.get(22));
                } else if (number == 24) {
                    Greece.getInstance().setCountry(regions.get(24));
                    labels.add(new CountryLabel());
                    labels.get(16).setPrototypeRegion(Greece.getInstance());
                    labels.get(16).setCountry(regions.get(24));
                } else if (number == 25) {
                    Iberia.getInstance().setCountry(regions.get(25));
                    labels.add(new CountryLabel());
                    labels.get(17).setPrototypeRegion(Iberia.getInstance());
                    labels.get(17).setCountry(regions.get(25));
                } else if (number == 26) {
                    Italy.getInstance().setCountry(regions.get(26));
                    labels.add(new CountryLabel());
                    labels.get(18).setPrototypeRegion(Italy.getInstance());
                    labels.get(18).setCountry(regions.get(26));
                }

//                numbers.add(number);
                number++;
            } else {
                System.err.println("Unexpected value! " + pathSegmentType);
            }

            pi.next();
        }

        return regions;
    }

    class MousePositionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            // do nothing
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            refresh();
            System.out.println(e.getSource().toString());
        }
    }

    class MouseClickListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
////            CountryLabel chuj = labels.stream().filter(e1 -> e.getSource().equals(e1)).findFirst().orElse(null);
////            Point point = new Point(e.getX(), e.getY());
//            Point p = MouseInfo.getPointerInfo().getLocation();
//            Point p1 = output.getLocationOnScreen();
//            int x = p.x - p1.x;
//            int y = p.y - p1.y;
//            Point pointOnImage = new Point(x, y);
//            for (CountryLabel label : labels) {
//                if (((CountryLabel) e.getSource()).getBorder() == (label.getBorder()) && ((CountryLabel) e.getSource()).getCountry().getNumber() == 20) {
//                    System.out.println(label.getPrototypeRegion());
//                }
////                if (label.contains(pointOnImage)) {
////                    System.out.println(label.getPrototypeRegion());
////                }
//            }
//
////            System.out.println(((CountryLabel) e.getSource()).getPrototypeRegion().getCountry());
//            onClick();
//            System.out.println(e.getSource());
//            refresh();
            BufferedImage bi = new BufferedImage(
                    2 * SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

            Graphics2D g = bi.createGraphics();
            g.drawImage(image, 0, 0, output);
            g.setColor(Color.ORANGE.darker());
            g.fill(area);
            g.setColor(Color.RED);
            g.draw(area);
            try {
                Point p = MouseInfo.getPointerInfo().getLocation();
                Point p1 = output.getLocationOnScreen();
                int x = p.x - p1.x;
                int y = p.y - p1.y;
                Point pointOnImage = new Point(x, y);
                for (Country country : shapeList) {
                    if (country.getShape().contains(pointOnImage)) {
                        g.setColor(Color.GREEN.darker());
                        g.fill(country.getShape());
                        System.out.println(MessageFormat.format("Country clicked {0}", country.getNumber()));
                        System.out.println(MessageFormat.format("Country clicked {0}", country.getShape()));
                        if (country.getNumber() == 3) {
//                        Iceland.getInstance().setCountry(regions.get(3));
//                        labels.add(new CountryLabel());
//                        labels.get(0).setPrototypeRegion(Iceland.getInstance());
//                        labels.get(0).setCountry(regions.get(3));
                            Iceland.getInstance().setInfections(500);
                            System.out.println(Iceland.getInstance().getInfections());
                        } else if (country.getNumber() == 4) {
//                            NorthernEurope.getInstance().setCountry(regions.get(4));
//                            labels.add(new CountryLabel());
//                            labels.get(1).setPrototypeRegion(NorthernEurope.getInstance());
//                            labels.get(1).setCountry(regions.get(4));
                            NorthernEurope.getInstance().setInfections(500);
                            System.out.println(NorthernEurope.getInstance().getInfections());
                        } else if (number == 5) {
                            Denmark.getInstance().setCountry(regions.get(5));
                            labels.add(new CountryLabel());
                            labels.get(2).setPrototypeRegion(Denmark.getInstance());
                            labels.get(2).setCountry(regions.get(5));
                        } else if (number == 6) {
                            Baltics.getInstance().setCountry(regions.get(6));
                            labels.add(new CountryLabel());
                            labels.get(3).setPrototypeRegion(Baltics.getInstance());
                            labels.get(3).setCountry(regions.get(6));
                        } else if (number == 8) {
                            Ireland.getInstance().setCountry(regions.get(8));
                            labels.add(new CountryLabel());
                            labels.get(4).setPrototypeRegion(Ireland.getInstance());
                            labels.get(4).setCountry(regions.get(8));
                        } else if (number == 9) {
                            UK.getInstance().setCountry(regions.get(9));
                            labels.add(new CountryLabel());
                            labels.get(5).setPrototypeRegion(UK.getInstance());
                            labels.get(5).setCountry(regions.get(9));
                        } else if (number == 10) {
                            Poland.getInstance().setCountry(regions.get(10));
                            labels.add(new CountryLabel());
                            labels.get(6).setPrototypeRegion(Poland.getInstance());
                            labels.get(6).setCountry(regions.get(10));
                        } else if (number == 11) {
                            WesternEurope.getInstance().setCountry(regions.get(11));
                            labels.add(new CountryLabel());
                            labels.get(7).setPrototypeRegion(WesternEurope.getInstance());
                            labels.get(7).setCountry(regions.get(11));
                        } else if (number == 14) {
                            Germany.getInstance().setCountry(regions.get(14));
                            labels.add(new CountryLabel());
                            labels.get(8).setPrototypeRegion(Germany.getInstance());
                            labels.get(8).setCountry(regions.get(14));
                        } else if (number == 15) {
                            EasternEurope.getInstance().setCountry(regions.get(15));
                            labels.add(new CountryLabel());
                            labels.get(9).setPrototypeRegion(EasternEurope.getInstance());
                            labels.get(9).setCountry(regions.get(15));
                        } else if (number == 16) {
                            CentralEurope.getInstance().setCountry(regions.get(16));
                            labels.add(new CountryLabel());
                            labels.get(10).setPrototypeRegion(CentralEurope.getInstance());
                            labels.get(10).setCountry(regions.get(16));
                        } else if (number == 17) {
                            Switzerland.getInstance().setCountry(regions.get(17));
                            labels.add(new CountryLabel());
                            labels.get(11).setPrototypeRegion(Switzerland.getInstance());
                            labels.get(11).setCountry(regions.get(17));
                        } else if (number == 18) {
                            France.getInstance().setCountry(regions.get(18));
                            labels.add(new CountryLabel());
                            labels.get(12).setPrototypeRegion(France.getInstance());
                            labels.get(12).setCountry(regions.get(18));
                        } else if (number == 19) {
                            SouthEasternEurope.getInstance().setCountry(regions.get(19));
                            labels.add(new CountryLabel());
                            labels.get(13).setPrototypeRegion(SouthEasternEurope.getInstance());
                            labels.get(13).setCountry(regions.get(19));
                        } else if (number == 20) {
                            Balkans.getInstance().setCountry(regions.get(20));
                            labels.add(new CountryLabel());
                            labels.get(14).setPrototypeRegion(Balkans.getInstance());
                            labels.get(14).setCountry(regions.get(20));
                        } else if (number == 22) {
                            Turkiye.getInstance().setCountry(regions.get(22));
                            labels.add(new CountryLabel());
                            labels.get(15).setPrototypeRegion(Turkiye.getInstance());
                            labels.get(15).setCountry(regions.get(22));
                        } else if (number == 24) {
                            Greece.getInstance().setCountry(regions.get(24));
                            labels.add(new CountryLabel());
                            labels.get(16).setPrototypeRegion(Greece.getInstance());
                            labels.get(16).setCountry(regions.get(24));
                        } else if (number == 25) {
                            Iberia.getInstance().setCountry(regions.get(25));
                            labels.add(new CountryLabel());
                            labels.get(17).setPrototypeRegion(Iberia.getInstance());
                            labels.get(17).setCountry(regions.get(25));
                        } else if (number == 26) {
                            Italy.getInstance().setCountry(regions.get(26));
                            labels.add(new CountryLabel());
                            labels.get(18).setPrototypeRegion(Italy.getInstance());
                            labels.get(18).setCountry(regions.get(26));
                        }
                        break;
                    }
                }
            } catch (Exception doNothing) {
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

    }

    public static boolean isIncluded(Color target, Color pixel, int tolerance) {
        int rT = target.getRed();
        int gT = target.getGreen();
        int bT = target.getBlue();
        int rP = pixel.getRed();
        int gP = pixel.getGreen();
        int bP = pixel.getBlue();
        return ((rP - tolerance <= rT) && (rT <= rP + tolerance)
                && (gP - tolerance <= gT) && (gT <= gP + tolerance)
                && (bP - tolerance <= bT) && (bT <= bP + tolerance));
    }

    private void refresh() {
        output.setIcon(new ImageIcon(getImage()));
//        for (Country country : regions) {
//            if ()
//        }
//        output.setPrototypeRegion();
    }

    private void onClick() {
        try {
            Point p = MouseInfo.getPointerInfo().getLocation();
            Point p1 = output.getLocationOnScreen();
            int x = p.x - p1.x;
            int y = p.y - p1.y;
            Point pointOnImage = new Point(x, y);
            for (Country country : shapeList) {
                if (output.getCountry().getShape().contains(pointOnImage)) {
                    System.out.println(MessageFormat.format("Country clicked {0}", country.getNumber()));
                    System.out.println(MessageFormat.format("Country clicked {0}", country.getShape()));
                    if (country.getNumber() == 1) {
                        Balkans balkans = Balkans.getInstance();
                        balkans.setCountry(country);
                    }
                    break;
                }
            }
        } catch (Exception doNothing) {
        }
    }

    private BufferedImage getImage() {
        List<CountryLabel> labels = new ArrayList<>();
        BufferedImage bi = new BufferedImage(
                2 * SIZE, SIZE, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.drawImage(image, 0, 0, output);
        g.setColor(Color.ORANGE.darker());
        g.fill(area);
        g.setColor(Color.RED);
        g.draw(area);
        try {
            Point p = MouseInfo.getPointerInfo().getLocation();
            Point p1 = output.getLocationOnScreen();
            int x = p.x - p1.x;
            int y = p.y - p1.y;
            Point pointOnImage = new Point(x, y);
            for (Country country : shapeList) {
                if (country.getShape().contains(pointOnImage)) {
                    g.setColor(Color.GREEN.darker());
                    g.fill(country.getShape());
                    System.out.println(MessageFormat.format("Country clicked {0}", country.getNumber()));
                    System.out.println(MessageFormat.format("Country clicked {0}", country.getShape()));
                    if (country.getNumber() == 3) {
//                        Iceland.getInstance().setCountry(regions.get(3));
//                        labels.add(new CountryLabel());
//                        labels.get(0).setPrototypeRegion(Iceland.getInstance());
//                        labels.get(0).setCountry(regions.get(3));
                        Iceland.getInstance().setInfections(500);
                        System.out.println(Iceland.getInstance().getInfections());
                    } else if (number == 4) {
                        NorthernEurope.getInstance().setCountry(regions.get(4));
                        labels.add(new CountryLabel());
                        labels.get(1).setPrototypeRegion(NorthernEurope.getInstance());
                        labels.get(1).setCountry(regions.get(4));
                    } else if (number == 5) {
                        Denmark.getInstance().setCountry(regions.get(5));
                        labels.add(new CountryLabel());
                        labels.get(2).setPrototypeRegion(Denmark.getInstance());
                        labels.get(2).setCountry(regions.get(5));
                    } else if (number == 6) {
                        Baltics.getInstance().setCountry(regions.get(6));
                        labels.add(new CountryLabel());
                        labels.get(3).setPrototypeRegion(Baltics.getInstance());
                        labels.get(3).setCountry(regions.get(6));
                    } else if (number == 8) {
                        Ireland.getInstance().setCountry(regions.get(8));
                        labels.add(new CountryLabel());
                        labels.get(4).setPrototypeRegion(Ireland.getInstance());
                        labels.get(4).setCountry(regions.get(8));
                    } else if (number == 9) {
                        UK.getInstance().setCountry(regions.get(9));
                        labels.add(new CountryLabel());
                        labels.get(5).setPrototypeRegion(UK.getInstance());
                        labels.get(5).setCountry(regions.get(9));
                    } else if (number == 10) {
                        Poland.getInstance().setCountry(regions.get(10));
                        labels.add(new CountryLabel());
                        labels.get(6).setPrototypeRegion(Poland.getInstance());
                        labels.get(6).setCountry(regions.get(10));
                    } else if (number == 11) {
                        WesternEurope.getInstance().setCountry(regions.get(11));
                        labels.add(new CountryLabel());
                        labels.get(7).setPrototypeRegion(WesternEurope.getInstance());
                        labels.get(7).setCountry(regions.get(11));
                    } else if (number == 14) {
                        Germany.getInstance().setCountry(regions.get(14));
                        labels.add(new CountryLabel());
                        labels.get(8).setPrototypeRegion(Germany.getInstance());
                        labels.get(8).setCountry(regions.get(14));
                    } else if (number == 15) {
                        EasternEurope.getInstance().setCountry(regions.get(15));
                        labels.add(new CountryLabel());
                        labels.get(9).setPrototypeRegion(EasternEurope.getInstance());
                        labels.get(9).setCountry(regions.get(15));
                    } else if (number == 16) {
                        CentralEurope.getInstance().setCountry(regions.get(16));
                        labels.add(new CountryLabel());
                        labels.get(10).setPrototypeRegion(CentralEurope.getInstance());
                        labels.get(10).setCountry(regions.get(16));
                    } else if (number == 17) {
                        Switzerland.getInstance().setCountry(regions.get(17));
                        labels.add(new CountryLabel());
                        labels.get(11).setPrototypeRegion(Switzerland.getInstance());
                        labels.get(11).setCountry(regions.get(17));
                    } else if (number == 18) {
                        France.getInstance().setCountry(regions.get(18));
                        labels.add(new CountryLabel());
                        labels.get(12).setPrototypeRegion(France.getInstance());
                        labels.get(12).setCountry(regions.get(18));
                    } else if (number == 19) {
                        SouthEasternEurope.getInstance().setCountry(regions.get(19));
                        labels.add(new CountryLabel());
                        labels.get(13).setPrototypeRegion(SouthEasternEurope.getInstance());
                        labels.get(13).setCountry(regions.get(19));
                    } else if (number == 20) {
                        Balkans.getInstance().setCountry(regions.get(20));
                        labels.add(new CountryLabel());
                        labels.get(14).setPrototypeRegion(Balkans.getInstance());
                        labels.get(14).setCountry(regions.get(20));
                    } else if (number == 22) {
                        Turkiye.getInstance().setCountry(regions.get(22));
                        labels.add(new CountryLabel());
                        labels.get(15).setPrototypeRegion(Turkiye.getInstance());
                        labels.get(15).setCountry(regions.get(22));
                    } else if (number == 24) {
                        Greece.getInstance().setCountry(regions.get(24));
                        labels.add(new CountryLabel());
                        labels.get(16).setPrototypeRegion(Greece.getInstance());
                        labels.get(16).setCountry(regions.get(24));
                    } else if (number == 25) {
                        Iberia.getInstance().setCountry(regions.get(25));
                        labels.add(new CountryLabel());
                        labels.get(17).setPrototypeRegion(Iberia.getInstance());
                        labels.get(17).setCountry(regions.get(25));
                    } else if (number == 26) {
                        Italy.getInstance().setCountry(regions.get(26));
                        labels.add(new CountryLabel());
                        labels.get(18).setPrototypeRegion(Italy.getInstance());
                        labels.get(18).setCountry(regions.get(26));
                    }
                    break;
                }
            }
        } catch (Exception doNothing) {
        }

        g.dispose();

        return bi;
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            WorldMapArea o = new WorldMapArea();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.setResizable(false);
            f.pack();

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
//        Runnable q = () -> {
//            numbers.stream().forEach(System.out::println);
//        };
//        SwingUtilities.invokeLater(q);
    }
}
