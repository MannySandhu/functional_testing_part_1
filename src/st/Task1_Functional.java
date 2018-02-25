package st;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
    public void setUp() throws Exception {
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

}
