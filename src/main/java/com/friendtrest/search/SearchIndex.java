package com.friendtrest.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class SearchIndex {
	
	private HashMap<Integer, Integer> document_count;
	private HashMap<Integer, LinkedList<String>> reverse_index; //maps token indices to the records which contain them
	private HashMap<String, Integer> token_index; //maps tokens to an integer
	
	public SearchIndex() {
		document_count = new HashMap<Integer, Integer>();
		reverse_index = new HashMap<Integer, LinkedList<String>>();
		token_index = new HashMap<String, Integer>();
	}
	
	public void addRecord(String uuid, String content) {
		content = content.replaceAll("\\p{P}", )
	}
	
	public List<Integer> getResults(int[] keyword_indices) {
		List<Integer> document_indices = new LinkedList<Integer>(); //TODO: change to uuid
		
		for (int index : keyword_indices) {
			document_indices.add(reverse_index.get(index));
		}
		
		return document_indices;
	}
	
	
}
