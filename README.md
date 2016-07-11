# Build-It-Bigger

#### Project Overview
In this project, created an app with multiple flavors that uses multiple libraries and Google Cloud Endpoints. The finished app will consist of four modules:

1. A Java library that provides jokes
2. A Google Cloud Endpoints (GCE) project that serves those jokes
3. An Android Library containing an activity for displaying jokes 
4. An Android app that fetches jokes from the GCE module and passes them to the Android Library for display 


#### Why this Project?
As Android projects grow in complexity, it becomes necessary to customize the behavior of the Gradle build tool, allowing automation of repetitive tasks. Particularly, factoring functionality into libraries and creating product flavors allow for much bigger projects with minimal added complexity.
![alt tag](https://github.com/Gr8manish/Build-It-Bigger/blob/master/Screenshots/project_overview.png "Overview of project")

#### What I Learned?

I learned the role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity. I learned to:
* Add free and paid flavors to an app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi-project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server


#### How I Completed this Project?

##### Step 1: Create a Java library

created a Java library that provides jokes. Created a new Gradle Java project Then introduce a project dependency between app and the new Java Library.

Make the button display a toast showing a joke retrieved from your Java joke telling library.

##### Step 2: Create an Android Library

Create an Android Library containing an Activity that display a joke passed to it as an intent extra. Wire up project dependencies so that the button can now pass the joke from the Java Library to the Android Library.

##### Step 3: Create GCE Module

Instead of pulling jokes directly from our Java library set up a GCE development server, and pull jokes from there.

Introduce a project dependency between your Java library and GCE module, and modify the GCE starter code to pull jokes from your Java library. Create an Async task to retrieve jokes. Made the button kick off a task to retrieve a joke, then launch the activity from Android Library to display it.

##### Step 4: Add Functional Tests

Added code to test that Async task successfully retrieves a non-empty string.

##### Step 5: Add a Paid Flavor

Added free and paid product flavors to your app. Removed the ad (and any dependencies) from the paid flavor.

##### Step 6: Add Interstitial Ad

Display the ad after the user hits the button, and before the joke is shown.

##### Step 7: Add Loading Indicator

Add a loading indicator that is shown while the joke is being retrieved, and disappears when the joke is ready.

![alt tag](https://github.com/Gr8manish/Build-It-Bigger/blob/master/Screenshots/BIB_one.png "Build-It-Bigger")![alt tag](https://github.com/Gr8manish/Build-It-Bigger/blob/master/Screenshots/BIB_two.png "Build-It-Bigger")![alt tag](https://github.com/Gr8manish/Build-It-Bigger/blob/master/Screenshots/BIB_three.png "Build-It-Bigger")![alt tag](https://github.com/Gr8manish/Build-It-Bigger/blob/master/Screenshots/BIB_four.png "Build-It-Bigger")

