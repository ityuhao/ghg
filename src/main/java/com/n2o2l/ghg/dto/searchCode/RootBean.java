/**
  * Copyright 2019 bejson.com 
  */
package com.n2o2l.ghg.dto.searchCode;
import java.util.List;

/**
 * Auto-generated: 2019-01-13 7:50:20
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class RootBean {

    private int total_count;
    private boolean incomplete_results;
    private List<Items> items;
    public void setTotal_count(int total_count) {
         this.total_count = total_count;
     }
     public int getTotal_count() {
         return total_count;
     }

    public void setIncomplete_results(boolean incomplete_results) {
         this.incomplete_results = incomplete_results;
     }
     public boolean getIncomplete_results() {
         return incomplete_results;
     }

    public void setItems(List<Items> items) {
         this.items = items;
     }
     public List<Items> getItems() {
         return items;
     }

}