package com.brianc.testRepo;

import java.security.Permission;

/**
 * Hello world!
 *
 */
public class DoNotTerminate {

		public static class ExitTrappedException extends SecurityException {

			private static final long serialVersionUID = 1;
	 }

	 public static void forbidExit() {
	  final SecurityManager securityManager = new SecurityManager() {
	   @Override
	   public void checkPermission(Permission permission) {
	    if (permission.getName().contains("exitVM")) {
	     throw new ExitTrappedException();
	    }
	   }
	  };
	  System.setSecurityManager(securityManager);
	 }
	}
