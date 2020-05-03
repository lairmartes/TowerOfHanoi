# TowerOfHanoi
Tower of Hanoi game - college project

I started this code when I was on College.
This is a simple Tower of Hanoi game created for implementing test stacks.
I included a simple graphical interface that allows the gamer moving disks between pins.
The objective is create a mobile application with this game.
The first step is create unit tests that will allow change the application code.
Later, the application will be refactored for changing application structure and make separated projects for GUI and game controller. This way, will be possible to create further views for this game rather than current Swing GUI.


# Project update (May, 2, 2020)

All core functions to control the game have been moved to `com.martialdev.game.core.HanoiTowerCore` (available in Maven).
I didn't change the user interface or the game dynamic.  Just removed the unused components, tests and redesigned the application to work with events in lieu of controlling the user actions in GUI code.

Project has been migrated to Maven.