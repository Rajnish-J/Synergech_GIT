package CollectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	static Map<String, String> CountryMap = new HashMap<String, String>();

	public static void main(String[] args) {
		MapDemo m = new MapDemo();

		m.storeCountryCapital("India", "New Delhi");
		m.storeCountryCapital("US", "Washington");
		m.storeCountryCapital("Japan", "Tokyo");

		System.out.println("captial of Japan: " + m.retrieveCapital("Japan"));

		System.out.println("Country with capital New Delhi: " + m.retrieveCountry("New Delhi"));
	}

	public void storeCountryCapital(String countryName, String capital) {
		CountryMap.put(countryName, capital);
	}

	public String retrieveCapital(String countryName) {
		return CountryMap.get(countryName);
	}

	public String retrieveCountry(String capital) {
		String ret = null;
		Set<String> countrySet = CountryMap.keySet();
		Iterator<String> it = countrySet.iterator();

		while (it.hasNext()) {
			String country = it.next();
			if (CountryMap.get(country).equals(capital)) {
				ret = country;
			}
		}

		return ret;
	}
}
