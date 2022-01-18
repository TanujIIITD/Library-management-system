
import java.util.*;
  
class AP_ass4 {
	static Scanner scn = new Scanner(System.in);
  
    public static void print_data(ArrayList<String> store_titles, ArrayList<Integer> store_isbns, ArrayList<Integer> store_barcodes, int racks, int slots) {
    	int count = 0;
    	for (int i = 0; i < racks; i++) {
    		System.out.println("************************************************************");
    		System.out.println("rack "+(i+1)+": ");
    		System.out.println("************************************************************");
    		System.out.println("");
    		for (int j = 0; j < slots; j++) {
    			System.out.println("slot "+(j+1)+": ");
    			System.out.println("title: "+store_titles.get(count));
    			System.out.println("ISBN "+store_isbns.get(count));
    			System.out.println("barcode "+store_barcodes.get(count));
    			System.out.println("");
    			
    			count++;
    		}
    		System.out.println("");
    	}
    }
  
    public static void main(String[] args) {
    	System.out.println("Tell the number of books: ");
    	int books = scn.nextInt();
    	
    	System.out.println("Tell the number of racks: ");
    	int racks = scn.nextInt();
    	
    	int slots = books/racks;
    	
    	ArrayList<String> store_titles = new ArrayList<String>();
    	ArrayList<Integer> store_isbns = new ArrayList<Integer>();
    	ArrayList<Integer> store_barcodes = new ArrayList<Integer>();
    	
    	for (int i = 0; i < books; i++) {
    		System.out.println();
    		
    		System.out.println("title of book "+(i+1)+" : ");
    		String title = scn.nextLine();
    		if ((title == null) || (title == "")) {
    			title = scn.nextLine();
    		}
    		store_titles.add(title);
    		
    		System.out.println("ISBN of book "+(i+1)+": ");
    		int isbn = scn.nextInt();
    		store_isbns.add(isbn);
    		
    		System.out.println("barcode of book "+(i+1)+": ");
    		int barcode = scn.nextInt();
    		store_barcodes.add(barcode);
    	}
    	System.out.println();
        
        sorting asd = new sorting();
        
        ArrayList<ArrayList<Integer>> help1 = new ArrayList<ArrayList<Integer>>();
        help1 = asd.sort_by_title(store_titles, store_isbns, store_barcodes);
        store_isbns = help1.get(0);
        store_barcodes = help1.get(1);
      
        ArrayList<ArrayList<Integer>> help2 = new ArrayList<ArrayList<Integer>>();
        help2 = asd.sort_by_ISBN(store_titles, store_isbns, store_barcodes);
        store_isbns = help2.get(0);
        store_barcodes = help2.get(1);
       
        store_barcodes = asd.sort_by_barcode(store_titles, store_isbns, store_barcodes);
        
        
        print_data(store_titles, store_isbns, store_barcodes, racks, slots);
    }
}



class sorting {
	public ArrayList<ArrayList<Integer>> sort_by_title(ArrayList<String> store_titles, ArrayList<Integer> store_isbns, ArrayList<Integer> store_barcodes) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	while (true) {
    		int count = 0;
	    	for (int i = 0; i < store_titles.size(); i++) {
	    		for (int j = i+1; j < store_titles.size(); j++) {
	    			if (store_titles.get(i).compareToIgnoreCase(store_titles.get(j)) > 0) {
	    				String temp = store_titles.get(j);
	    				store_titles.set(j, store_titles.get(i));
	    				store_titles.set(i, temp);
	    				
	    				int temp1 = store_isbns.get(j);
						store_isbns.set(j, store_isbns.get(i));
						store_isbns.set(i, temp1);
						
						int temp2 = store_barcodes.get(j);
						store_barcodes.set(j, store_barcodes.get(i));
						store_barcodes.set(i, temp2);
						
						count++;
	    			}
	    		}
	    	}

			if (count == 0) {
				break;
			}
    	}
    	
    	Collections.sort(store_titles);
    	
    	ret.add(store_isbns);
    	ret.add(store_barcodes);
        return ret;
	}
	
	public ArrayList<ArrayList<Integer>> sort_by_ISBN(ArrayList<String> store_titles, ArrayList<Integer> store_isbns, ArrayList<Integer> store_barcodes) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
		while (true) {
			int count = 0;
			for (int i = 0; i < store_titles.size(); i++) {
				for (int j = i+1; j < store_titles.size(); j++) {
					if (store_titles.get(i).equals(store_titles.get(j))) {
						if (store_isbns.get(i) > store_isbns.get(j)) {
							int temp1 = store_isbns.get(j);
							store_isbns.set(j, store_isbns.get(i));
							store_isbns.set(i, temp1);
							
							int temp2 = store_barcodes.get(j);
							store_barcodes.set(j, store_barcodes.get(i));
							store_barcodes.set(i, temp2);
							
							count++;
						}
					}
				}
			}
			
			if (count == 0) {
				break;
			}
		}
		
		ret.add(store_isbns);
    	ret.add(store_barcodes);
		return ret;
	}

	public ArrayList<Integer> sort_by_barcode(ArrayList<String> store_titles, ArrayList<Integer> store_isbns, ArrayList<Integer> store_barcodes) {
		while (true) {
			int count = 0;
			for (int i = 0; i < store_barcodes.size(); i++) {
				for (int j = i+1; j < store_barcodes.size(); j++) {
					if (store_isbns.get(i).equals(store_isbns.get(j))) {
						if (store_barcodes.get(i) > store_barcodes.get(j)) {
							int temp1 = store_barcodes.get(j);
							store_barcodes.set(j, store_barcodes.get(i));
							store_barcodes.set(i, temp1);
							
							count++;
						}
					}
				}
			}
			
			if (count == 0) {
				break;
			}
		}
		
		return store_barcodes;
	}

}