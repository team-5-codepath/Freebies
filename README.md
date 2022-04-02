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
[Evaluation of your app across the following attributes]
- **Category:** E-commerce / Social Networking
- **Mobile:** The primary usage platform for this app would be mobile because users can take a picture, upload it, and display the item they would like to trade. All of this could be done with their mobile device. The functionality could easily extend to a computer, but the mobile device is better suited because notifications will allow transactions to occur at a faster pace.
- **Story:**  Modern users want to clear up space and declutter. In addition, users want to be able to sift through a catalog of items so that they can find what they want without having to overspend. This interplay allows users to be donors/sellers and consumers on our
- **Market:** The market is far-ranging because e-commerce is a popular way people get to unload undesired items and load up on items they need or want.
- **Habit:** This app would be highly habit-forming because the UI/UX would make it easy for customers to see items that they are targeting but also pique their interests in other items. They could consistently upload the items they want to unload and keep track of them on the platform.
- **Scope:** Initially it would be individuals that are familiar with e-commerce platforms but over time we hope that the ease-of-use will help bring in those who are unfamiliar with e-commerce. Eventually we can facilitate this service to businesses that need to unload items.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can sign up to create a new account
* User can login and logout of his/her account
* User can take a picture and post it to app 
* User can view a feed of post 
* User can leave comments under posts
* Every posts show up in the timeline
* User can refresh posts timeline by pulling down to refresh


**Optional Nice-to-have Stories**

* User can like and unlike posts
* User can show up the location in the feed of post
* User can search for a post
* User can make a wish list of items
* User can trade via app

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
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]