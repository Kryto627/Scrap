package com.kryto.scrap.profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProfileManager {

	private static ProfileManager instance = new ProfileManager();
	
	public static ProfileManager getInstance() {
		return instance;
	}
	
	public Profile[] profiles;
	
	private Profile currentProfile;
	
	private ProfileManager() {
		profiles = new Profile[3];
	}
	
	public Profile getCurrentProfile() {
		return currentProfile;
	}
	
	public void loadProfile(int index) {
		
		if (profiles[index] == null) {			
			profiles[index] = new Profile();			
		}
		
		else {
			
			currentProfile = profiles[index];
		}
	}
	
	public void cleanProfiles() {
		
		for(int i = 0; i < profiles.length; i++) {
			
			if (profiles[i] != null && profiles[i].markForDelete) {
				profiles[i] = null;
			}
		}
	}
	
	public void save() {
		
		cleanProfiles();		
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("profiles.bin"));
			
			oos.writeObject(profiles);
			oos.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void load() {
		
		File file = new File("profiles.bin");
		
		if (file.exists()) {
			
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				
				profiles = (Profile[]) ois.readObject();
				ois.close();
			} 
			
			catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}	
		}
	}
}
