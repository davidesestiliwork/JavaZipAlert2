/*
	JavaZip Alert2
	Copyright (C) 2024 Davide Sestili

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

public class JavaZipAlert2 
{
	public static void main(String[] args) 
	{
		if(args.length == 0)
		{
			System.out.println("Usage: directory to zip");
		}
		else
		{
			try 
			{
				ProcessBuilder builder = new ProcessBuilder("java", "-jar", "JavaZipAlert.jar", args[0]);
				Process process = builder.start();
				int exitCode = process.waitFor();
				if(exitCode == 0)
				{
					builder = new ProcessBuilder("java", "-jar", "JavaZip.jar", args[0]);
					process = builder.start();
					process.waitFor();
				}
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
