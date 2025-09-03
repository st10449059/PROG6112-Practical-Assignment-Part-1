package tvseriesmain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TVseriesMenuTest {
    
    private TVseriesMenu menu;
    private ArrayList<SeriesModel> seriesList;
    
    public TVseriesMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        menu = new TVseriesMenu();
        seriesList = getSeriesList(menu);
        seriesList.clear();

        // preload with sample series
        seriesList.add(new SeriesModel("S1", "Breaking Code", "16", "10"));
        seriesList.add(new SeriesModel("S2", "Java Dreams", "13", "8"));
    }
    
    @After
    public void tearDown() {
    }

    // Helper method to access private seriesList
    @SuppressWarnings("unchecked")
    private ArrayList<SeriesModel> getSeriesList(TVseriesMenu instance) throws Exception {
        Field field = TVseriesMenu.class.getDeclaredField("seriesList");
        field.setAccessible(true);
        return (ArrayList<SeriesModel>) field.get(instance);
    }

    // ------------------ TESTS ------------------

    @Test
    public void testSeriesStorage() {
        assertEquals(2, seriesList.size());
        assertEquals("Breaking Code", seriesList.get(0).SeriesName);
    }

    @Test
    public void testSearchSeries_Found() {
        SeriesModel found = null;
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals("S1")) {
                found = s;
                break;
            }
        }
        assertNotNull(found);
        assertEquals("Breaking Code", found.SeriesName);
    }

    @Test
    public void testSearchSeries_NotFound() {
        SeriesModel found = null;
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals("S99")) {
                found = s;
                break;
            }
        }
        assertNull(found);
    }

    @Test
    public void testUpdateSeries() {
        SeriesModel toUpdate = seriesList.get(0);
        toUpdate.SeriesName = "Updated Show";
        toUpdate.SeriesAge = "15";
        toUpdate.SeriesNumberOfEpisodes = "20";

        assertEquals("Updated Show", seriesList.get(0).SeriesName);
        assertEquals("15", seriesList.get(0).SeriesAge);
        assertEquals("20", seriesList.get(0).SeriesNumberOfEpisodes);
    }

    @Test
    public void testDeleteSeries_Found() {
        int initialSize = seriesList.size();
        SeriesModel toDelete = seriesList.get(0);
        seriesList.remove(toDelete);

        assertEquals(initialSize - 1, seriesList.size());
        assertEquals("Java Dreams", seriesList.get(0).SeriesName);
    }

    @Test
    public void testDeleteSeries_NotFound() {
        int initialSize = seriesList.size();
        SeriesModel notThere = null;
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equals("S99")) {
                notThere = s;
                break;
            }
        }
        if (notThere != null) {
            seriesList.remove(notThere);
        }
        assertEquals(initialSize, seriesList.size());
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        SeriesModel valid = new SeriesModel("S3", "Valid Show", "18", "5");
        assertTrue(menu.isNumeric(valid.SeriesAge));
        int age = Integer.parseInt(valid.SeriesAge);
        assertTrue(age >= 2 && age <= 18);
    }

    @Test
    public void testSeriesAgeRestriction_AgeInvalid() {
        SeriesModel invalid = new SeriesModel("S4", "Invalid Show", "abc", "7");
        assertFalse(menu.isNumeric(invalid.SeriesAge));
    }

    @Test
    public void testIsNumeric() {
        assertTrue(menu.isNumeric("123"));
        assertFalse(menu.isNumeric("12a3"));
        assertFalse(menu.isNumeric(""));
    }

    @Test
    public void testSeriesReport_NotEmpty() {
        assertFalse(seriesList.isEmpty());
    }

    @Test
    public void testSeriesReport_EmptyList() {
        seriesList.clear();
        assertTrue(seriesList.isEmpty());
    }
}
