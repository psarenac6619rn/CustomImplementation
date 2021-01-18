package sk.projekat.custom_implementacija;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import sk.projekat.specifikacija.Entitet;
import sk.projekat.specifikacija.Specifikacija;

public class CustomImplementacija extends Specifikacija{

	@Override
	public void absOpenDatabase(boolean isNew, int fileCount) {
		if(isNew)
			return;
		this.read(fileCount);
		
	}

	@Override
	public void read(int fileNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(int fileNumber) {
		for(int i = 0; i < this.getFileCount(); i++) {
			File file = new File(this.getDirectory().getAbsolutePath() + "/" + i + ".cust");
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter(file, false);
				BufferedWriter bw = new BufferedWriter(fw);
				
			} catch (IOException e) {
				
			}
		}
		
	}
	
	private String entToString(ArrayList<Entitet> entiteti) {
		String s = "";
		for(Entitet e: entiteti) {
			s = s.concat("//\nid:" + e.getId() + "\nname:" + e.getName() + "params:\n");
			HashMap<String, String> polja = (HashMap<String, String>) e.getPolja();
			for(Map.Entry<String, String> ent: polja.entrySet()) {
				s = s.concat("\t" + ent.getKey() + ":" + ent.getValue() + "\n");
			}
			s = s.concat("Ugnjezdeni:");
			HashMap<String, Entitet> ugnEnt = (HashMap<String, Entitet>) e.getUgnjezdeniEntiteti();
			for(Map.Entry<String, Entitet> ent: ugnEnt.entrySet()) {
				s = s.concat(ent.getKey() + ":");
				Entitet entitet = ent.getValue();
			}
		} 
		return s;
	}

}
