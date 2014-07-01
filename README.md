mooniker
========

A small console Java application to rename all files in a directory. It's ideal for torrented files, where all the downloads have silly things like "[HD] [SuperTorrents] (1080p)".


Instructions for Use
========
You must first specify the directory to rename files in. The directory itself will not be renamed. 

Then you must specify the string to be replaced in every filename.

The next thing you must input is the string to replace the previous one. 

Now you must add the depth you want to rename files to. If you input "0", only the directory you specified will have its files renamed. 

If you input "1", the directory and all immediate subdirectories will have their files renamed. If you input "*" or "-1", then all subdirectories will be recursively renamed.

Next you must specify "Y" or "N" to say whether you want to rename the directories themselves (instead of just the files within the directories). 


That's It!
========
Heyoo! You just need to compile Mooniker.java (with the command "javac Mooniker.java") and then run it with "java Mooniker". The in-program prompts will echo what I said above and guide you through the process. Soon enough I'll compile it and let it be run some other way than compiling it yourself. 
