package com.brianc.testRepo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookerApp {

	private ZooKeeper zookeeper;
	private static ZookerApp zkApp;
	private Properties prop;

	private String ZookerAddress;
	
	public ZookerApp () {
		try {
			
			loadProperties();
			
			zookeeper = new ZooKeeper( prop.getProperty("zooker.server-address"), 3000, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void loadProperties() throws IOException {

		prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();    
		InputStream stream = loader.getResourceAsStream("./application.properties");
		prop.load(stream);
	}

	private void zooTalk() throws KeeperException, InterruptedException {
		
		// Write data to the znode "/myZnode"
		String path = "/testtopic";
		String data = "hello world";
		Stat zooStats = zookeeper.exists(path, false);
		if ( zooStats != null ) {
		
			zookeeper.create(path, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		 
			// Read data from the znode "/myZnode"
			byte[] bytes = zookeeper.getData(path, false, null);
			String readData = new String(bytes);
		 
			// Prints "hello world"
			System.out.println(readData);  
		 
			// Closing the connection 
			// to the ZooKeeper ensemble
			zookeeper.close();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 zkApp = new ZookerApp();
		
		 try {
			zkApp.zooTalk();
		} catch (KeeperException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
