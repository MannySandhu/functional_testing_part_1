package st;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import st.EntryMap.Entry;

public class Task1_Functional_unused {
	
    private EntryMap map;

    private TemplateEngine engine;
    
    private SimpleTemplateEngine simpleEngine;
	
    @Before
    public void setUp() throws Exception {
        map = new EntryMap();
        engine = new TemplateEngine();
        simpleEngine = new SimpleTemplateEngine();
    }

	@Test
	public void storeTest1() {
		Exception ex = null;
		try {
			map.store(null, "Adam");
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void storeTest2() {
		Exception ex = null;
		try {
			map.store("name", null);
		} catch (Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void storeTest3() {
		map.store("name", "Adam");
		map.store("surname", "Dykes");
		
		ArrayList<Entry> entries = map.getEntries();
		
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Adam");
		expected.add("Dykes");
		
		int i = 0;
		boolean test = true;
		
		for(Entry e : entries) { 
			if(!e.getValue().equals(expected.get(i++)))
				test = false;
		}
		
		assertTrue(test);
	}
	
	@Test
	public void storeTest4() {
		map.store("name", "Adam");
		map.store("name", "Bob");
		
		int actualSize = map.getEntries().size(), expectedSize = 1;
		
		assertTrue(actualSize == expectedSize && map.getEntries().get(0).getValue().equals("Adam")); 
	}
	
	@Test
	public void storeTest5() {
		map.store("name", "Adam");
		map.store("name", "Adam");
		
		int actualSize = map.getEntries().size(), expectedSize = 1;
		
		assertTrue(actualSize == expectedSize); 
	}

}
