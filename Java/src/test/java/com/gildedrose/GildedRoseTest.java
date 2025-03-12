package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo, -1, 0", app.items[0].toString());
//        assertAll("Producto",
//        		()->assertEquals("foo", items[0].name),
//        		()->assertEquals(-1, items[0].sellIn, "SellIn"),
//        		()->assertEquals(0, items[0].quality, "Quality")
//        		);
    }    

    
    @Nested
	@DisplayName("Elixir of the Mongoose")
    class Elixir {
    	@Test
        void decrementarQuality() {
            Item[] items = new Item[] { new Item("Elixir of the Mongoose", 10, 30) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
//            assertEquals(9, app.items[0].sellIn);
//            assertEquals(29, app.items[0].quality);
            assertEquals("Elixir of the Mongoose, 9, 29", app.items[0].toString());
        }
       
        @Test
        void qualityPositivo() {
            Item[] items = new Item[] { new Item("Elixir of the Mongoose", 10, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();           
            assertEquals("Elixir of the Mongoose, 9, 0", app.items[0].toString());
        }
    }
    
    @Nested
	@DisplayName("Aged Brie")
    class AgedBrie {
    	@Test
        void max50AgedBrie() {
            Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };  
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie, 9, 50", app.items[0].toString());
        }
        
        @Test
        void agedBrieIncrementar() {
            Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie, 1, 1", app.items[0].toString());
        }
        
        @Test
        void agedBrieExpiradaFechaAumentarDoble() {
            Item[] items = new Item[] { new Item("Aged Brie", -1, 40) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals("Aged Brie, -2, 42", app.items[0].toString());
        }
        
        @Test
        void agedBrieexpiradaFechaQuality50() {
            Item[] items = new Item[] { new Item("Aged Brie", -1, 50) };
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(-2, app.items[0].sellIn);
            assertEquals(50, app.items[0].quality);
        }
    }   
    
    @Nested
   	@DisplayName("Backstage")
       class Backstage { 
		   
		    @Test
		    @DisplayName("SellIn < 11, Quality < 50")
		    void incrementar2() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 40) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(8, app.items[0].sellIn);
		        assertEquals(42, app.items[0].quality);
		    }
		    
		    @Test
		    @DisplayName("SellIn >= 11, Quality < 50")
		    void incrementar2sell11() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 40) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(10, app.items[0].sellIn);
		        assertEquals(41, app.items[0].quality);
		    }
		    
		    @Test
		    @DisplayName("SellIn < 11, Quality = 50")
		    void incrementar250() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(9, app.items[0].sellIn);
		        assertEquals(50, app.items[0].quality);
		    }
		    
		    @Test
		    @DisplayName("SellIn >= 11, Quality = 50")
		    void incrementar21150() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(10, app.items[0].sellIn);
		        assertEquals(50, app.items[0].quality);
		    }
		   
		    @Test
		    @DisplayName("SellIn < 6, Quality < 50")
		    void incrementar3() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 40) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(3, app.items[0].sellIn);
		        assertEquals(43, app.items[0].quality);
		    }
		    
		    @Test
		    @DisplayName("SellIn < 6, Quality = 50")
		    void incrementar350() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(3, app.items[0].sellIn);
		        assertEquals(50, app.items[0].quality);
		    }    
		    
		    @Test
		    void perderCalidad() {
		        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 40) };
		        GildedRose app = new GildedRose(items);
		        app.updateQuality();
		        assertEquals(-1, app.items[0].sellIn);
		        assertEquals(0, app.items[0].quality);
		    }  
    
    }
    
    @Test
    void otroProducto() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void conjured() {
    	Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void conjured1() {
    	Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
    
    /* Utilizando Approvals.verify */
    
    @Test
//	@Disabled
	void instantanea() {
		Item[] items = new Item[] { 
				new Item("+5 Dexterity Vest", 10, 20), 
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7), 
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet 
				new Item("Conjured Mana Cake", 3, 6) 
				};

		GildedRose app = new GildedRose(items);
		StringBuilder output = new StringBuilder();
		output.append("day,name, sellIn, quality\n");
		List.of(items).forEach(item -> output.append("0," + item + "\n"));
		for (int i = 1; i <= 31; i++) {
			app.updateQuality();
			for(Item item: items)
				output.append(i + "," + item + "\n");
		}
		Approvals.verify(output);
	}

}
