# RIDEmory 🚙
A self-updating database of ride information for Emory students accessible via the web or GroupMe.

Currently WIP, watch the repository and check back for updates!

## Table of Contents

* [Vision](#vision)
  * [Design](#design)
  * [Features](#features)
* [Docs](#docs)
  * [File Structure](#file-structure)
  * [Setup](#setup)
* [Miscellaneous](#miscellaneous)

## Vision

RIDEmory seeks to **ensure a smoother ride-sharing experience for Emory students.** To do so, we provide:
* Automatically compiled ride information
* Easy access to said ride information
* An updated collection of travel information from TSA wait times to estimated Uber/Lyft rates

through both a website and a bot in GroupMe.

### Design

RIDEmory is split into three main components:

* [Frontend](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/frontend)
  * Provides anonymous information about upcoming requested rides on both GroupMe and from registered users
  * Allows sorting of rides by date, time (both leaving and flight time), location (to/from)
  * Also provides organized travel information
* [Backend](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/backend)
  * Does all the heavy lifting, communicating with the bot to update the database of rides
  * Also compiles travel information and neatly packages it for the frontend
  * Acts as an interface for most compiled information
* [Bot](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/bot)
  * Scrapes GroupMe for rideshare information, automatically sending it to the backend
  * Responds to chat commands for information
  * Also acts as an interface to GroupMe for things like message likes, user ID, etc

### Features

* Frontend
  - [ ] TODO
* Backend
  - [ ] TODO
* Bot
  - [ ] TODO

## Docs

For more specific information on each component, see their respective READMEs (located in their respective directories)

### File Structure

TODO

### Setup

TODO

### Testing

See each component's README for specific instructions on running and debugging its code.

## Miscellaneous

Made with ❤️ by the Project Pandas, ©️ Project Emory 2023 under the ⚖️ GNU GPL-3.0 license
