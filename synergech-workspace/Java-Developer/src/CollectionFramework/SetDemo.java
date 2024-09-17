package CollectionFramework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
	static Set<String> countries = new HashSet<String>();

	public static void main(String[] args) {
		SetDemo s = new SetDemo();

		s.storeCountryNames("India");
		s.storeCountryNames("Australia");
		s.storeCountryNames("England");

		System.out.println(countries);

		s.retriveCountry("India");
		s.retriveCountry("USA");
	}

	public void storeCountryNames(String countryName) {
		countries.add(countryName);
	}

	public void retriveCountry(String countryName) {
		Iterator<String> i = countries.iterator();
		boolean flag = false;

		while (i.hasNext()) {
			String countryname = i.next();
			if (countryName.equals(countryname)) {
				flag = true;
				break;
			}
		}
		System.out.println(flag ? "Country Exists" : "Country does not exists");
	}
}
