package mmt.comradepigman.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import mmt.comradepigman.components.GameProject;

public final class ProjectLoader {

	public static void saveProject(GameProject project) {
		try {
			String fileName = project.getPName().replace(" ", "_").toLowerCase();
			// TODO: Better implementation of this code

			FileOutputStream fileOut = new FileOutputStream(
					System.getProperty("user.dir") + "/saves/" + fileName + ".mmt");

			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(project);

			out.close();
			fileOut.close();

		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static GameProject loadProject(File file) {
		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);

			GameProject e = (GameProject) in.readObject();
			in.close();
			fileIn.close();

			return e;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
