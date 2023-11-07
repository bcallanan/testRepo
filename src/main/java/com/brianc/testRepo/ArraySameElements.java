package com.brianc.testRepo;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class ArraySameElements {

	static boolean sameElementsHashSet(Object[] array1, Object[] array2) {

		Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
		Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));
		
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

    public static void main(String[] args) throws IOException {
		Integer[] a1 = {1,2,3,2,1};
		Integer[] a2 = {1,2,3};
		Integer[] a3 = {1,2,3,4};
		
		System.out.println(sameElementsHashSet(a1, a2));
		System.out.println(sameElementsHashSet(a1, a3));
    }
}
