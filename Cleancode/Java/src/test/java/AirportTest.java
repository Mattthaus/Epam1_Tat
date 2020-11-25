import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private Airport airportToTest;

    @BeforeTest
    private void createAirportForTesting(){
        List<Plane> planesList = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new ExperimentalPlane("Bell X-14", 277, 482, 500,  ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500,  ClassificationLevel.TOP_SECRET));

        airportToTest = new Airport(planesList);
    }

    @DataProvider()
    public Object[][] allPlanesProvider(){
        return new Object[][]{{
                Arrays.asList(
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                        new ExperimentalPlane("Bell X-14", 277, 482, 500,  ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500,  ClassificationLevel.TOP_SECRET)
                )
        }
        };
    }

    @Test(dataProvider = "allPlanesProvider")
    public void getAllPlanesTest(List<? extends Plane> expected){
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }

    @DataProvider()
    public Object[][] getPassengerPlanesProvider(){
        return new Object[][]{{
                Arrays.asList(
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
                )
        }
        };
    }

    @Test(dataProvider = "getPassengerPlanesProvider")
    public void getPassengerPlanesTest(List<PassengerPlane> expected){
        Assert.assertEquals(expected, airportToTest.getPassengerPlanes());
    }

    @DataProvider()
    public Object[][] getExperimentalPlanesProvider(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET)
                )
        }
        };
    }

    @Test(dataProvider = "getExperimentalPlanesProvider")
    public void getExperimentalPlanesTest(List<ExperimentalPlane> expected){
        Assert.assertEquals(expected, airportToTest.getExperimentalPlanes());
    }

    @DataProvider()
    public Object[][] getMilitaryPlanesProvider(){
        return new Object[][]{{
                Arrays.asList(
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
                )
        }
        };
    }

    @Test(dataProvider = "getMilitaryPlanesProvider")
    public void getMilitaryPlanesTest(List<MilitaryPlane> expected){
        Assert.assertEquals(expected, airportToTest.getMilitaryPlanes());
    }

    @DataProvider()
    public Object[][] getSortedByMaxSpeedPlanes(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER)
                )
        }
        };
    }

    @Test(dataProvider = "getSortedByMaxSpeedPlanes")
    public void sortByMaxSpeedTest(List<Plane> expected){
        airportToTest.sortByMaxSpeed();
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }

    @DataProvider()
    public Object[][] getSortedByMaxLoadCapacityPlanes(){
        return new Object[][]{{
                Arrays.asList(
                        new ExperimentalPlane("Bell X-14", 277, 482, 500, ClassificationLevel.SECRET),
                        new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ClassificationLevel.TOP_SECRET),
                        new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                        new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                        new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                        new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
                        new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                        new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                        new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                        new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                        new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                        new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                        new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                        new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                        new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                        new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
                )
        }
        };
    }

    @Test(dataProvider = "getSortedByMaxLoadCapacityPlanes")
    public void sortByMaxByMaxLoadCapacityTest(List<Plane> expected){
        airportToTest.sortByMaxLoadCapacity();
        Assert.assertEquals(expected, airportToTest.getAllPlanes());
    }
}
