import java.io.File;
import java.util.Scanner;


class Mooniker{
	public static void main(String[] args){
		if(args.length == 0){
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the directory you would like to rename in:");
			String dir = in.nextLine();
			System.out.println("Enter the string you would like to remove:");
			String prev = in.nextLine();
			System.out.println("Enter the string you need to replace it with:");
			String post = in.nextLine();
			System.out.println("Enter the directory depth you would like to rename to:");
			String depthString = in.nextLine();
			int depth = 0;
			if(depthString.charAt(0) == '*'){
				depth = -1;
			}else{
				depth = Integer.parseInt(depthString);
			}
			System.out.println("Do you want to rename directories too? Y/N");
			String renameDirsString = in.nextLine();
			boolean renameDirs = (renameDirsString.equalsIgnoreCase("Y") || renameDirsString.equalsIgnoreCase("yes") || renameDirsString.equalsIgnoreCase("true"));
			System.out.println("");
			renameFilesInDir(dir, prev, post, depth, renameDirs);
		}
	}
	
	public static void renameFilesInDir(String dir, String prev, String post, int depth, boolean renameDirs){
		File directory = new File(dir);
		File[] allFiles = directory.listFiles();
		
		System.out.println("Directory \"" + dir + "\" being renamed.");
		for(File file : allFiles){
			if(file.isFile()){
				if(!file.getName().contains(prev)) continue;
				String fileName = file.getName();
				String path = getFilePath(file);
				String newName = fileName.replace(prev, post);
				//System.out.println(fileName + " ->" + path + File.separator + newName + ".");
				File newFile = new File(path + File.separator + newName);
				//System.out.println(newFile.getAbsolutePath());
				renameFile(file.getAbsolutePath(), newFile.getAbsolutePath());
			}
		}
		
		
		depth --;
		for(File file : allFiles){
			if(file.isDirectory()){
				String fileName = file.getName();
				String path = getFilePath(file);
				String newName = fileName.replace(prev, post);
				File newFile = new File(path + File.separator + newName);
				if(renameDirs) renameFile(file.getAbsolutePath(), newFile.getAbsolutePath());
				
				if(depth == 0) continue;
				renameFilesInDir(file.getAbsolutePath(), prev, post, depth, renameDirs);
			}
		}
		
		System.out.println("");
	}
	
	public static void renameFile(String prev, String post){
		File old = new File(prev);
		File file = new File(post);
		if(file.exists()){
			System.out.println("File \"" + post + "\" already exists.");
			return;
		}
		boolean success = old.renameTo(file);
		if(!success){
			System.out.println("Could not rename file \""+  prev + "\" to \"" + post + "\".");
		}else{
			System.out.println("File \"" + prev + "\" renamed to \"" + post + "\".");
		}
	}
	
	public static String getFilePath(File file){
		String absolutePath = file.getAbsolutePath();
		String filePath = absolutePath.substring(0,absolutePath.lastIndexOf(File.separator));
		return filePath;
	}
}
