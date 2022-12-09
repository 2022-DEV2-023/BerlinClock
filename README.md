# Berlin Clock

## About this Kata

This short and simple Kata should be performed using **Test Driven Development** (TDD).

## Rules

The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the time using a series of illuminated coloured blocks, as you can see in the picture for this project.

The top lamp blinks to show seconds- it is illuminated on even seconds and off on odd seconds.

The next two rows represent hours. The upper row represents 5 hour blocks and is made up of 4 red lamps. The lower row represents 1 hour blocks and is also made up of 4 red lamps.

The next two rows represent the minutes. The upper row represents 5 minute blocks, and is made up of 11 lamps- every third lamp is red, the rest are yellow. The bottom row represents 1 minute blocks, and is made up of 4 yellow lamps.

The final row shows the time in HH:MM format

## Technologies used
- MVVM
- Test Driven Development
- Unit tests

## Tools used:
- Android Studio Dolphin | 2021.3.1
- Gradle 7.4
- 
## How to run this app
- checkout the code

```bash
 git clone https://github.com/2022-DEV2-023/BerlinClock.git
```

- open the project in Android Studio
- perform a Gradle build to load all the dependencies
- run the app with SHIFT + F10 (Windows) or CTRL + R (Mac)

## Run tests:
- Right click on test folder
- Start tests with CTRL + SHIFT + F10 (Windows) or CTRL + SHIFT + R (Mac)