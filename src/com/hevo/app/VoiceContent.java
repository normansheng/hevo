package com.hevo.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoiceContent {
	/**
	 * An array of sample (dummy) items.
	 */
	public List<VoiceItem> ITEMS = new ArrayList<VoiceItem>();

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, VoiceItem> ITEM_MAP = new HashMap<String, VoiceItem>();

	public void addItem(VoiceItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class VoiceItem {
		public String id;
		public String content;

		public VoiceItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
