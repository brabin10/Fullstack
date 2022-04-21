package com.ravature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import com.ravature.models.Pokemon;

//Collections are like Arrays in that they are objects that data BUT there are quite a few differences
//Collections can only hold objects (we'll talk more about wrapper classes)

public class Launcher {

	public static void main(String[] args) {

		System.out.println("=================================(Lists)");

		// ArrayList is a very common implementation of the List Interface
		// QC asked me the difference between ArrayLists and Lists

		// Making an ArrayList of Pokemon Objects
		ArrayList<Pokemon> myPokemonList = new ArrayList<>(); // empty ArrayList which we'll fill below

		// .add() method lets us add elements to our Lists
		// so here, we're creating the object as we add it to the ArrayList. We could
		// also have instantiated before adding
		myPokemonList.add(new Pokemon("Jolteon", "Electric"));
		myPokemonList.add(new Pokemon("Charmander", "Fire"));
		myPokemonList.add(new Pokemon("Gengar", "Ghost/Poison"));
		myPokemonList.add(new Pokemon("Rayquaza", "Dragon/Flying"));
		myPokemonList.add(new Pokemon("Ditto", "Normal"));
		myPokemonList.add(new Pokemon("Mudkip", "Water"));
		myPokemonList.add(new Pokemon("Pikachu", "Electric"));
		
		//add(index) will add an object at a specific index
		myPokemonList.add(0,new Pokemon("Pikachu", "Electric"));

		// we can print out an ArrayList thanks to the toString() method in the Pokemon
		// Class
		System.out.println(myPokemonList);
		
		// But it'll be cleaner to use an enchanced for loop to iterate over the data structure
		for(Pokemon p:myPokemonList) {
			System.out.println(p);
		}
		//.get(index) is how we select elements at a certain index
		System.out.println("The Pokemon at index 3 is: " + myPokemonList.get(3).name);
		
		//.size() is analogous to .length in Arrays, it returns an int of the size of the collection
		System.out.println("I have " + myPokemonList.size() + " Pokemon in my party");
		
		//we're going to to do aforEach loop to make the Pokemon "fight"
		//This arrow is called a lamba function, they're like a quick one-time use method
		myPokemonList.forEach(pokemon -> pokemon.fight());
		
		//.remove() will remove a specific element given in the index
		myPokemonList.remove(4);
		myPokemonList.remove(2);
		
		//use a forEach loop to print out the remaining Pokemon
		myPokemonList.forEach(pokemon-> System.out.println(pokemon.name + "remains"));
		
		System.out.println("====Sets====");
		
		//Instantiate an empty Hashset
		HashSet<Pokemon> myPokemonSet = new HashSet<>();
		
		//Make some Pokemon objects
		Pokemon totodile = new Pokemon("Totodie", "Water");
		Pokemon chansey = new Pokemon("Chansey", "Normal");
		Pokemon torchic = new Pokemon("Torchic", "Fire");
		Pokemon pidgey = new Pokemon("Pidgey", "Normal/Flying");
		
		//Add those Pokemon objects into our Hashset
		myPokemonSet.add(totodile);
		myPokemonSet.add(chansey);
		myPokemonSet.add(torchic);
		myPokemonSet.add(pidgey);
		myPokemonSet.add(pidgey);
		
		//Notice how sets have no particular order, unlike Lists
		//also note how duplicates are allowed
		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		//.contains()returns a boolean of true if the set contains the specified object
		if(myPokemonSet.contains(torchic)) {
			System.out.println("Torchic is in my party!");
		}else {
			System.out.println("No Torchics to be found");
		}
		
		//Sets have no index...but if we use .iterator(), we can create an Iterator from that Set's values
		Iterator<Pokemon> iterator = myPokemonSet.iterator();
		
		//hasNext() checks to see if there are values as we iterate through a data 
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		System.out.println("====Queues====");
		
		LinkedList<Pokemon> pokemonLL = new LinkedList<>();
		
		//add some pokemon
		pokemonLL.add(new Pokemon("Wobbuffet", "Psychic"));
		pokemonLL.add(new Pokemon("Snorlaxc", "Normal"));
		pokemonLL.add(new Pokemon("Mew", "Psychic"));
		
		//Iterate threough the LinkedList and print out the values using an ehchanced for loop
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		
		//Just like with Lists, Queues have a strit order
		
		//.peek() selects the first value
		System.out.println(pokemonLL.peek().name + " is the first Pokemon in the LinkedList");
		
		//.poll() selects and removes the first values
		System.out.println(pokemonLL.poll().name + " has left the chat...");
		
		//Print them out
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		
		System.out.println("=========Maps========");
		
		
		//Instantiate a TreeMap, which is our general purpose Map type
		//This TreeMap takes Integer for the key, and Pokemon for the value
		TreeMap<Integer, Pokemon> pokeMap = new TreeMap<>();
		
		//why are we using Integer instead of int?
		//collections only deal with objects! we have to use what's called the wrapper class for primitives
		//Basically, every primitives has a class version, for when we need objects, like in collections.
		
		//use the .put() method to insert values into the map
		//these pokemon objects are coming from the ones we made when we did Sets
		pokeMap.put(1, pidgey);
		pokeMap.put(2, chansey);
		pokeMap.put(15, torchic);
		
		//we can find values by searching for a key
		System.out.println(pokeMap.get(1));
		
		//size of the TreeMap is 3 despite the keys going up to 15
		System.out.println(pokeMap.size());
		
		//Keys can be Alphabetic as well, doesn't have to be Integers
		TreeMap<String, String> newTreeMap = new TreeMap<>();
		
		newTreeMap.put("A", "This is the letter A");
		newTreeMap.put("B", "This is the letter B");
		newTreeMap.put("C", "This is the letter C");
		
		System.out.println(newTreeMap);
		
		
	
	}

}