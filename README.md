# Introduction

This is the Android part of module 387COM 'Mobile Applications Development' at Coventry University. The module leader for this module is Mark Tyers. The person responsible for the teaching of the Android part is Jianhua Yang.

There are altogether 22 labs to be delivered in 11 weeks. That is 2 labs per week. This document contains the module plan for academic year 15-16, and assessment plan (subject to changes). In the Android part of the module, we closely follow the overall structure/pace of the iOS part whenever possible. For iOS part of the module see [here](https://github.com/covcom/387COM).

# Teaching plan

## Week 1 Android Studio

### Introduction to Android Studio

**Contents**

Installation of Java JDK/Android Studio, AVD, 'Hello World', navigating Android Studio, Context Menus, getting help

**Refs**

[Ref.[1]](#ref1) chapter 1/2

### Debugging

**Contents**

Git common operations, logging, debugger's tool window

**Refs**

[Ref.[1]](#ref1) chapter 7/12

## Week 2 The Java language

### Language concepts

**Contents**

Data type, variable, expressions, identifiers, statements

Code generation, refactoring

**Refs**

[Ref.[1]](#ref1) chapter 3

[Ref.[2]](#ref2) chapter 2

### Classes and objects

**Contents**

Classes, constants, methods, constructors, modifiers, inheritance

Google Java style

**Refs**

[Ref.[3]](#ref3) chapter 5

[Google Java Style](https://google-styleguide.googlecode.com/svn/trunk/javaguide.html)

## Week 3 XML and Gradle

### XML

**Contents**

App manifest, XML schema, syntax, styles

**Refs**

[Ref.[3]](#ref3) chapter 4

### Gradle

**Contents**

IntelliJ build system, Gradle build concepts, Android lib dependencies

**Refs**

[Ref.[1]](#ref1) chapter 13

[App Manifest](http://developer.android.com/guide/topics/manifest/manifest-intro.html)

[Build System Overview](https://developer.android.com/sdk/installing/studio-build.html)

[Gradle Plugin User Guide](http://tools.android.com/tech-docs/new-build-system/user-guide)

## Week 4 Simple Views and Layouts

### UI design

**Contents**

MVC pattern, activity lifecycle, layouts, and intents

Pattern usability and design principles: animation, style, layout, components, pattern, usability

**Refs**

[Ref.[4]](#ref4) chapter 2

[Android official API guide: Material Design](http://developer.android.com/design/index.html)

### Simple and complex view

**Contents**

Common controls, AdapterView, Spinner, ProgressBar, Android threading

**Refs**

[Ref.[4]](#ref4) chapter 3/4

## Week 5 AdapterViews and Fragments

### AdapterViews

**Contents**

Simple listview, complex listview, adapter view, Grid view

**Refs**

[Ref.[4]](#ref4) chapter 4

[Android official API guide: List View ](http://developer.android.com/guide/topics/ui/layout/listview.html)

### Fragments

**Contents**

Fragments, specialized fragments, screen orientation

**Refs**

[Ref.[4]](#ref4) chapter 4

## Week 6 Data persistence

### SharedPreferences and files

**Contents**

SharedPreferences API, Android Device Monitor, Java IO, writing and reading to files, internal/external storage

**Refs**

[Ref.[5]](#ref5) chapter 11/12

### SQL database

**Contents**

SQLite API, helper class, pre-creating databases

**Refs**

[Ref.[4]](#ref4) chapter 6

## Week 7 Testing

### Unit testing

**Contents**

JUnit essentials, Unit test best practices, local unit testing, mocked unit testing

**Refs**

[Ref.[5]](#ref5) chapter 18

[vogella tutorials: Unit Testing with JUnit](http://www.vogella.com/tutorials/JUnit/article.html)

### Instrumented testing

**Contents**

Instrumented unit tests, UI testing using Espresso

**Refs**

[Android official API guide: Testing fundamentals](http://developer.android.com/tools/testing/testing_android.html)


## Week 8 Wearables

### Notifications on Android wearables

**Contents**

Android services, broadcasting, notifications

### Android wear apps

**Contents**

Setting up wearable environment, optimize for screen technologies, build watchface service, initialize drawable resources and styles

**Refs**

[Ref.[1]](#ref1) chapter 15

[Ref.[3]](#ref3) chapter 15


## Week 9 Graphics and animation

### Graphics

**Contents**

ViewPager, Drawable resources, extended View class

**Refs**

[Ref.[3]](#ref3) chapter 9

[Ref.[4]](#ref4) chapter 5

### Animation

**Contents**

Property animation, View animation

**Refs**

[Ref.[3]](#ref3) chapter 10

[Android official API guide: Adding Animations](http://developer.android.com/training/animation/index.html)

## Week 10 Location services and Google maps

### Location services

**Contents**

Getting location, retrieve updates, display address

**Refs**

[Android official API guide: Making Your App Location-Aware](http://developer.android.com/training/location/index.html)

### Google maps

**Contents**

Google maps

**Refs**

[Google Maps API for Android](https://developers.google.com/maps/documentation/android/)

## Week 11 Multimedia

### Audio playback

**Contents**

Volume, playback, audio focus

**Refs**

[Ref.[3]](#ref3) chapter 10

[Android official API guide: Managing Audio Playback](http://developer.android.com/training/managing-audio/index.html)

### Photos and videos

**Contents**

Camera2, Streaming video, MediaPlayer, MediaController

**Refs**

[Ref.[3]](#ref3) chapter 11

[Android official API guide: Capturing Photos](http://developer.android.com/training/camera/index.html)


# Assessment plan

Refer to Moodle for this

# Reading list

1. <a name="ref1"></a>[Learn Android Studio](http://www.amazon.co.uk/Learn-Android-Studio-Quickly-Effectively/dp/1430266015)
2. <a name="ref2"></a>[Learn Java for Android Development](http://www.amazon.co.uk/Learn-Java-Android-Development/dp/1430264543)
3. <a name="ref3"></a>[Android Apps for Absolute Beginners](http://www.amazon.co.uk/Android-Absolute-Beginners-Wallace-Jackson/dp/1484200209)
4. <a name="ref4"></a>[Beginning Android 4 Application Development](http://www.amazon.co.uk/Beginning-Android-4-Application-Development/dp/1118199545)
5. <a name="ref5"></a>[Introduction to Android Application Development](http://www.amazon.co.uk/Introduction-Android-Application-Development-Essentials/dp/0321940261)

# About this Github repository

This Github repository is set up to host lab materials and code examples we use throughout module 387COM. You can simply read and explore. If you would like a personal copy of it, you'll need to fork it as writing to it is not allowed. In the repository for module 305CDE, there is a [README](https://github.com/covcom/305CDE/blob/master/README.md) file written by Mark Tyers that explains how to fork repositories and keep them up to date.
