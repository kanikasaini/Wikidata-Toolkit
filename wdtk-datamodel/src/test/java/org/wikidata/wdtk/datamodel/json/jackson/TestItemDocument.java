package org.wikidata.wdtk.datamodel.json.jackson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.wikidata.wdtk.datamodel.json.jackson.ItemDocumentImpl;
import org.wikidata.wdtk.datamodel.json.jackson.ItemIdImpl;
import org.wikidata.wdtk.datamodel.json.jackson.MonolingualTextValueImpl;
import org.wikidata.wdtk.datamodel.json.jackson.SiteLinkImpl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestItemDocument extends JsonConversionTest {
	
	// puzzle pieces for creation of the test object
	Map<String, MonolingualTextValueImpl> testMltvMap;
	Map<String, List<MonolingualTextValueImpl>> testAliases;
	ItemIdImpl testItemId;
	Map<String, SiteLinkImpl> testSiteLinkMap;
	
	@Before
	public void setupTestMltv(){
		testMltvMap = new HashMap<>();
		testMltvMap.put("en", TestMonolingualTextValue.testMltv);
	}

	@Before
	public void setupTestAliases(){
		testAliases = new HashMap<>();
		List<MonolingualTextValueImpl> aliases = new LinkedList<>();
		aliases.add(TestMonolingualTextValue.testMltv);
		testAliases.put("en", aliases);
	}
	
	@Before
	public void setupTestItemId(){
		testItemId = new ItemIdImpl(itemId);
	}
	
	@Before
	public void setupTestSiteLinks(){
		testSiteLinkMap = new HashMap<>();
		testSiteLinkMap.put("enwiki", TestSiteLink.testSiteLink);
	}
	
	/**
	 * Tests the conversion of ItemDocuments containing labels from Pojo to Json
	 */
	@Test
	public void testLabelsToJson(){
		ItemDocumentImpl document = new ItemDocumentImpl();
		document.setLabels(testMltvMap);
		
		try {
			String result = mapper.writeValueAsString(document);
			JsonComparator.compareJsonStrings(wrappedLabelJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Converting Pojo to Json failed");
		}
	}
	
	/**
	 * Tests the conversion of ItemDocuments containing labels from Json to Pojo
	 */
	@Test
	public void testLabelToJava(){
		
		try {
			ItemDocumentImpl result = mapper.readValue(wrappedLabelJson, ItemDocumentImpl.class);
			
			assertNotNull(result);
			assertEquals(testMltvMap, result.getLabels());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail("Parsing failed");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail("Json mapping failed");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO failed");
		}
	}
	
	/**
	 * Tests the conversion of ItemDocuments containing descriptions from Pojo to Json
	 */
	@Test
	public void testDescriptionsToJson(){
		ItemDocumentImpl document = new ItemDocumentImpl();
		document.setDescriptions(testMltvMap);
		
		try {
			String result = mapper.writeValueAsString(document);
			JsonComparator.compareJsonStrings(wrappedDescriptionJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Converting Pojo to Json failed");
		}
	}

	/**
	 * Tests the conversion of ItemDocuments containing descriptions from Json to Pojo
	 */
	@Test
	public void testDescriptionsToJava(){
		
		try {
			ItemDocumentImpl result = mapper.readValue(wrappedDescriptionJson, ItemDocumentImpl.class);
			
			assertNotNull(result);
			assertEquals(testMltvMap, result.getDescriptions());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail("Parsing failed");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail("Json mapping failed");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO failed");
		}
	}

	@Test
	public void testAliasesToJson(){
		ItemDocumentImpl document = new ItemDocumentImpl();
		document.setAliases(testAliases);
		
		try {
			String result = mapper.writeValueAsString(document);
			JsonComparator.compareJsonStrings(wrappedAliasJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Converting Pojo to Json failed");
		}
	}
	
	@Test
	public void testAliasesToJava(){
		
		try {
			ItemDocumentImpl result = mapper.readValue(wrappedAliasJson, ItemDocumentImpl.class);
			
			assertNotNull(result);
			assertEquals(testAliases, result.getAliases());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail("Parsing failed");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail("Json mapping failed");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO failed");
		}
	}
	
	@Test
	public void testItemIdToJson(){
		ItemDocumentImpl document = new ItemDocumentImpl();
		document.setItemId(testItemId);
		
		try {
			String result = mapper.writeValueAsString(document);
			JsonComparator.compareJsonStrings(wrappedItemIdJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Converting Pojo to Json failed");
		}
	}
	
	@Test
	public void testItemIdToJava(){
		
		try {
			ItemDocumentImpl result = mapper.readValue(wrappedItemIdJson, ItemDocumentImpl.class);
			
			assertNotNull(result);
			assertEquals(testItemId, result.getEntityId());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail("Parsing failed");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail("Json mapping failed");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO failed");
		}
	}
	
	@Test
	public void testSiteLinksToJson(){
		ItemDocumentImpl document = new ItemDocumentImpl();
		document.setSitelinks(testSiteLinkMap);
		
		try {
			String result = mapper.writeValueAsString(document);
			JsonComparator.compareJsonStrings(wrappedSiteLinkJson, result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			fail("Converting Pojo to Json failed");
		}
	}
	
	@Test
	public void testSiteLinksToJava(){
		
		try {
			ItemDocumentImpl result = mapper.readValue(wrappedSiteLinkJson, ItemDocumentImpl.class);
			
			assertNotNull(result);
			assertEquals(testSiteLinkMap, result.getSiteLinks());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
			fail("Parsing failed");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			fail("Json mapping failed");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO failed");
		}
	}
}
