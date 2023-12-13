package com.brianc.testRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class ArrayOfIntsSameElements {

	static boolean sameElementsHashSet(Object[] a1, Object[] a2) {

		Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(a1));
		Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(a2));
		
		// if size is different, means there will be a mismatch
		if (uniqueElements1.size() != uniqueElements2.size()) return false;
		
		for (Object obj : uniqueElements1) {
			// element not present in both?
			if (!uniqueElements2.contains(obj)) return false;
		}
		
		return true;
	}

	static boolean sameElementsList(Object[] array1, Object[] array2) {

		List<Object> uniqueElements1 = Arrays.asList(array1);
		List<Object> uniqueElements2 = Arrays.asList(array2);
		
		// if size is different, means there will be a mismatch
		if (uniqueElements1.size() != uniqueElements2.size()) return false;
		for (Object obj : uniqueElements1) {
			// element not present in both?
			if (!uniqueElements2.contains(obj)) return false;
		}
		
		return true;
	}

	static List<Object> printSameElementsHashSet(List<Object> list1, List<Object> list2) {

		Set<Object> uniqueElements1 = new HashSet<>( list1 );
		Set<Object> uniqueElements2 = new HashSet<>( list2 );
		
		List<Object> sameElements = new ArrayList<>();
		
		for (Object obj : uniqueElements1) {
			// element not present in both?
			if ( uniqueElements2.contains(obj)) {
				sameElements.add( obj );
			}
		}
		
		return sameElements;
	}

	static List<Object> printDiffElementsHashSet(List<Object> list1, List<Object> list2) {

		Set<Object> uniqueElements1 = new HashSet<>( list1 );
		Set<Object> uniqueElements2 = new HashSet<>( list2 );
		
		List<Object> diffElements = new ArrayList<>();
		
		for (Object obj : uniqueElements1) {
			// element not present in both?
			if ( ! uniqueElements2.contains(obj)) {
				diffElements.add( obj );
			}
		}
	
		for (Object obj : uniqueElements2) {
			// element not present in both?
			if ( ! uniqueElements1.contains(obj)) {
				diffElements.add( obj );
			}
		}

		return diffElements;
	}

    public static void main(String[] args) throws IOException {
		Integer[] a1 = {1,2,3,2,1,5};
		Integer[] a2 = {1,2,3,6};
		Integer[] a3 = {1,2,3,4};
		
		System.out.println(sameElementsHashSet(a1, a2));
		System.out.println(sameElementsHashSet(a1, a3));
		List< Object > matches = printSameElementsHashSet( Arrays.asList( a1 ), Arrays.asList( a2 ));
		
		System.out.println(printSameElementsHashSet( matches, Arrays.asList( a3 )));
		
		List<Integer> integers = new ArrayList<>();
		//List<Integer> integers = Arrays.asList( a1 );
		//List<Integer> integers2 = ;
		List<Integer> integers3 = Arrays.asList( a3 );
		
		integers.addAll( Arrays.asList( a1 ));
		integers.addAll(1, Arrays.asList( a2 ));
		integers.addAll(integers.size(), integers3);
		integers
			.stream()
			.distinct()
			.filter( (x) -> matches.contains(x)?false:true )
			.forEach(System.out::println);
		
		List< Object > noneMatches1And2 = printDiffElementsHashSet( Arrays.asList( a1 ), Arrays.asList( a2 ));
		List< Object > noneMatches2And3 = printDiffElementsHashSet( Arrays.asList( a2 ), Arrays.asList( a3 ));
		List< Object > noneMatches1And3 = printDiffElementsHashSet( Arrays.asList( a1 ), Arrays.asList( a3 ));
		List< Object > noneMatches1 = printDiffElementsHashSet( noneMatches1And2, noneMatches2And3);
		List< Object > noneMatches2 = printSameElementsHashSet( noneMatches1And2, noneMatches1And3); //1
		
		List< Object > noneMatches3 = printDiffElementsHashSet( noneMatches1And2, noneMatches1And3);
		List< Object > noneMatches4 = printSameElementsHashSet( noneMatches1, noneMatches2);
		List< Object > noneMatches5 = printDiffElementsHashSet( noneMatches2And3, noneMatches1And3);
		
		
		System.out.println( noneMatches1 );
		System.out.println( noneMatches2 );
		System.out.println( noneMatches3);//printDiffElementsHashSet( noneMatches, Arrays.asList( a3 )));

    }
}
