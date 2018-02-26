package st;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import st.EntryMap.Entry;

/*
 * 
 * 25.02.2018
 * @Author Mandeep Sandhu (s1784723)
 * Software Testing - Functional Testing Part 1
 * 
 * 
 */


public class Task1_Functional {
	
	// create objects
	private EntryMap map;
    private TemplateEngine engine;
    private SimpleTemplateEngine simpleEngine;
    
    
    // initialise objects
    @Before
    public void setUp() {
    	map = new EntryMap();
        engine = new TemplateEngine();
        simpleEngine = new SimpleTemplateEngine();
    }
    
    
    /* ===========================================================
     * 
     * JUnit tests for methods of the EntryMap class
     * EntryMap.store()
     * EntryMap.delete()
     * EntryMap.update()
     *  
     * ===========================================================/
    
    
    /* ===========================================================
     *  1. Test EntryMap.store() method
     *  
     *  Specification:
     *  Method takes arg1, arg2 of type string
     *  1. Template cannot be NULL or empty - throw runtime exception
     *  2. Replace value cannot be NULL - throw runtime exception
     *  3. Entries are ordered and appear in the same order as in program
     *  4. Entries that already exist cannot be stored again
     *  
     */
	@Test
	public void testSpec1NullTemplate() {
		
		Exception ex = null;
		try {
			map.store(null, "value");
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec1EmptyTemplate() {
		
		Exception ex = null;
		String empty = "";
		try {
			map.store(empty, "value");
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec2NullValue() {
		
		Exception ex = null;
		try {
			map.store("template", null);
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec3EntriesOrdered() {
		map.store("name", "Adam");
        map.store("name", "Bob");
       
        int actualSize = map.getEntries().size(), expectedSize = 1;
       
        assertTrue(actualSize == expectedSize && map.getEntries().get(0).getValue().equals("Adam"));   	
	}
	
	@Test
	public void testSpec4RepeatedEntry() {
		
		map.store("name", "Adam");
        map.store("name", "Adam");
       
        int actualSize = map.getEntries().size(), expectedSize = 1;
       
        assertTrue(actualSize == expectedSize); 
	}
	//============================================================
	
	/* ===========================================================
     *  2. Test EntryMap.delete() method
     *  
     *  Specification:
     *  Method takes arg1, arg2 of type string
     *  1. Template cannot be NULL or empty - throw runtime exception
     *  2. On deleting value/pair, entries remained ordered
     *  3. Only existing value/pair can be deleted
     *  
     */
	
	@Test
	public void testSpec2DeleteNullTemplate() {
		
		Exception ex = null;
		try {
			map.delete(null);
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec2DeleteEmptyTemplate() {
		
		Exception ex = null;
		String empty = "";
		try {
			map.delete(empty);
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpecDeleteExisting() {
		
		map.store("name","john");
		map.store("surname","smith");
		
		String deleteTemplate = "name";
		ArrayList<Entry> el = map.getEntries();
		int ini_size = el.size();
		
			for(Entry e : el) {
				
				String template = e.getPattern();
						
				if(template.equalsIgnoreCase(deleteTemplate)) {
					map.delete(template);
				}	
			}
			
		int new_size = el.size();	
		assertTrue(new_size < ini_size);
	}
	//============================================================
	
	/* ===========================================================
     *  3. Test EntryMap.update() method
     *  
     *  Specification:
     *  Method takes arg1, arg2 of type string
     *  1. Template cannot be NULL or empty - throw runtime exception
     *  2. Replace value cannot be NULL - throw runtime exception
     *  3. Operation does not change order
     *  4. Existing entries can only be updated
     *  
     */
	
	@Test
	public void testSpec3DeleteNullTemplate() {
		
		Exception ex = null;
		try {
			map.update(null, "john");
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec3DeleteEmptyTemplate() {
		
		Exception ex = null;
		String empty = "";
		try {
			map.update(empty, "john");
			
		}catch(Exception e) {
			ex = e;
		}
		assertTrue(ex instanceof RuntimeException);
	}
	
	@Test
	public void testSpec3KeepSameOrder() {
		
		map.store("name", "Adam");
        map.store("surname", "Bob");
        map.store("age", "34");
        
        map.update("surname", "smith");
        
		assertTrue(map.getEntries().get(1).getValue().equalsIgnoreCase("smith"));
	}

}
