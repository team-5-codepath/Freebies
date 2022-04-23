# Freebies

## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)
3. [Wireframes](#Wireframes)
4. [Schema](#Schema)

## Overview
### Description
Do you have random stuff taking up space in your house that still has some use? Are you looking for random item’s you see people just throwing out? Then Freebies is the app for you.

Freebies is a used item sharing app where users can sign up and post pictures of items that they want to give away and search for items other users are giving away.


### App Evaluation
- **Category:** E-commerce / Social Networking
- **Mobile:** The primary usage platform for this app would be mobile because users can take a picture, upload it, and display the item they would like to trade. All of this could be done with their mobile device. The functionality could easily extend to a computer, but the mobile device is better suited because notifications will allow transactions to occur at a faster pace.
- **Story:**  Modern users want to clear up space and declutter. In addition, users want to be able to sift through a catalog of items so that they can find what they want without having to overspend. This interplay allows users to be donors/sellers and consumers on our
- **Market:** The market is far-ranging because e-commerce is a popular way people get to unload undesired items and load up on items they need or want.
- **Habit:** This app would be highly habit-forming because the UI/UX would make it easy for customers to see items that they are targeting but also pique their interests in other items. They could consistently upload the items they want to unload and keep track of them on the platform.
- **Scope:** Initially it would be individuals that are familiar with e-commerce platforms but over time we hope that the ease-of-use will help bring in those who are unfamiliar with e-commerce. Eventually we can facilitate this service to businesses that need to unload items.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

  - [x] User can sign up to create a new account 
  - [x] User can login and logout of his/her account
  - [ ] User can take a picture and post it to app
  - [ ] User can view a feed of post
  - [ ] User can leave comments under posts
  - [ ] Every posts show up in the timeline
  - [ ] User can refresh posts timeline by pulling down to refresh


**Optional Nice-to-have Stories**

* User can like and unlike posts
* User can show up the location in the feed of post
* User can search for a post
* User can make a wish list of items
* User can trade via app

## progress Walkthrough

Here's a walkthrough of implemented user stories:

![Kapture 2022-04-22 at 23 18 00](https://user-images.githubusercontent.com/66290921/164873400-9453c922-c14c-434b-a0e4-5226b4909cd0.gif)

GIF created with [Kap] (https://getkap.co/).

<img src='https://github.com/team-5-codepath/Freebies/blob/main/user_story1_progress.gif' title='Video Walkthrough' width='250' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

### 2. Screen Archetypes

* Login/Signup
  * Upon Downloading the app new user is prompted to the login screen to sign up for access.
  * Upon reopening the app, if user logout of the app before, user can log back in through this screen.
* Home 
  * User can browse items that other users post to give away.
* Post
  * User can post picture of the item with description.
* Profile
  * User can edit personal profiles such as email. User can also logout of the app through this screen by clicking the logout button.
    

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Sign Up/Register (Home Page only)
* Login/Logout
* Post (Use the camera to take a picture)
* View (View a feed of the post)
* Comment

Optional
* Like & Unlike feature
* Location
* Search Post 
* WishList
* Trade


**Flow Navigation** (Screen to Screen)

* Home Page: Sign Up/Register and Login button
    * Home Page: Logged in --> Main Page
* Main Page: Post, View, Comment, Search Post
    * Main Page: View --> Once you're in the Main page, you will see a list of items
    * Main Page: Post --> Opens the camera to take a picture
    * Main Page: Search Post --> Search item you want
* Description Page: Like & Unlike, Location, Trade
    * Main Page: View --> Description Page --> Comment: You can write a comment under a Post
    * Main Page: View --> Description Page --> Like & Unlike: Like or Unlike an item 
    * Main Page: View --> Description Page --> Location: Shows the item location
* WishList Page: Create & Search wish item
    * WishList Page: Create --> Create a wish item
    * WishList Page: Search --> Search a wish item



## Wireframes
<img src="https://github.com/team-5-codepath/Freebies/blob/main/Images/wireframe.png" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema
[This section will be completed in Unit 9]
### Models
##### Post

| Property    | Type            | Description                           |
| ----------- | --------------- | ------------------------------------- |
| objectId    | String          | Unique id for the user post           |
| Author      | Pointer to User | Author of the post                    |
| Image       | File            | Image of the item                     |
| Description | String          | Description of the item               |
| ItemCount   | Int             | Number of Items that has been posted. |
| createdAt   | DateTime        | Date when post is created             |
| updatedAt   | DateTime        | Date when post is last updated        |
| Contact     | String          | Email of the user                     |

### Networking
#### List of network requests by screen

* Home Feed Screen

  * (Read/GET) Query all posts

  * (Create/POST) Create a new like on a post

  * ```js
    let like = PFObject(className:"Like")
    	like["name"] = "liked"
    
    	like.findObjectsInBackground { (succeeded, error)  in
        	if (succeeded) {
            	print("Successfully saved.")
        	}
        	else {
            print(error.localizedDescription)
        	}
    	}
    
    ```

  * (Delete) Delete existing like

  * ```js
    PFObject.removeAll(findObjectsInBackground: Like) { (succeeded, error) in
        if (succeeded) {
            print("Successfully deleted.")
        } else {
            print(error.localizedDescription)
        }
    }
    
    ```

* Message View Screen

  * (Read/GET) Query all posts user likes

* Chat View Screen

  * (Update/PUT) Update user comment

  * (Create/POST) Create a new comment on a post

  * ```js
    let comment = PFObject(className: "Comments")
       comment["author"] = PFUser.current()!
       comment["text"] = text
       comment["post"] = selectedPost
       selectedPost.add(comment, forKey: "comments")
    ```

  * ```js
    selectedPost.findObjectsInBackground { (success, error) in
           if success{
               print("Comment saved")
           }else {
               print("Error saving comment")
           }
       }
    ```

  * (Delete) Delete existing comment

  * ```js
    PFObject.removeAll(findObjectsInBackground: Comments) { (succeeded, error) in
         	if (succeeded) {
            	print("Successfully deleted.")
        	} else {
            print(error.localizedDescription)
        	}
    	}
    ```

* Profile View Screen

  * (Delete) Delete existing post object

  * (Read/GET) Query logged in user object

  * ```js
    let query = PFQuery(className:"Profile")
    	query.whereKey("author", equalTo: currentUser)
    
    	query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
       		if let error = error { 
          		print(error.localizedDescription)
       		} 
       		else if let users = users {
          		print("Successfully login")
      		}
    	}
    ```

  * (Update/PUT) Update user profile image

  * ```js
    let query = PFQuery(className:"Profile")
    	query.getObjectInBackground(withId: "?") { (Profile: PFObject?, error: Error?) in
    	    if let error = error {
    	        print(error.localizedDescription)
    	    } else if let Profile = Profile {
    	        Profile["image"] = newImage
    	    }
    	}
    ```

* Post View Screen

  * (Create/POST) Create a new post object

  * ```js
    let Post = PFObject(className:"Post")
    	Post["name"] = User
    	Post["text"] = Text
    	Post.saveInBackground { (succeeded, error)  in
        if (succeeded) {
            	print("Successfully Created.")
        	}
        	else {
            print(error.localizedDescription)
        	}
    	}
    ```



    

