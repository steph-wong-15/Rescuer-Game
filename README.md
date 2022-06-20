# Instructions 

If there's any miscellaneous questions, please email us at any of our respective emails, thanks!

## Running the game

To build the game, and run it, firstly download the entire project folder as a .zip file, which contains all the appropriate files (including the pom.xml file, which is needed for the proper version of javafx and required modules), and let Intellij handle it after extracting the folder. After doing that, navigate to the filepath, `"\src\main\java\com\group1"`, just right click on and execute Main.java, which will build and run your game. It will open up the opening screen, and you'll see a button to click on to play the game. In the file path, "\src\main\java\module-info.java", this should automatically require JavaFX modules `javafx.controls;` and `requires javafx.fxml; ` respectively. 


## Testing

Tests can all be run in **Intellij**, by navigating to `"src/test/java/com/group1/Test.java"`, and then right-clicking on the respective class you want to see the tests for. 

For example, if I want to run ScoreTest.

As you can see, all you have to do is right click on a file, and it will run all the appropriate tests corresponding to the class you selected. 


## Building JAR files for game and javadoc

Navigate to Maven control panel(this may vary depending on your ide) and click package.  Both game and javadoc jar files will be generated and will be located in the target folder.  Alternatively you can use `mvn package` command in terminal to build jar files, and will also be generated to target folder.
