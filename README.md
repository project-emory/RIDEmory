# RIDEmory 🚙

A self-updating database of ride information for Emory students accessible via the web or GroupMe.

Currently WIP, watch the repository and check back for updates!

## Table of Contents

- [Vision](#vision)
  - [Design](#design)
  - [Features](#features)
- [Docs](#docs)
  - [File Structure](#file-structure)
  - [Setup & Testing](#setup-&-testing)
- [Miscellaneous](#miscellaneous)

## Vision

RIDEmory seeks to **ensure a smoother ride-sharing experience for Emory students.** To do so, we provide:

- Automatically compiled ride information
- Easy access to said ride information
- An updated collection of travel information from TSA wait times to estimated Uber/Lyft rates

through both a website and a bot in GroupMe.

### Design

RIDEmory is split into three main components:

- [Frontend](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/frontend)
  - Provides anonymous information about upcoming requested rides on both GroupMe and from registered users
  - Allows sorting of rides by date, time (both leaving and flight time), location (to/from)
  - Also provides organized travel information
- [Backend](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/backend)
  - Does all the heavy lifting, communicating with the bot to update the database of rides
  - Also compiles travel information and neatly packages it for the frontend
  - Acts as an interface for most compiled information
- [Bot](https://github.com/PROJECT-Emory-2023/RIDEmory/tree/main/bot)
  - Scrapes GroupMe for rideshare information, automatically sending it to the backend
  - Responds to chat commands for information
  - Also acts as an interface to GroupMe for things like message likes, user ID, etc

### Features

- **Frontend (WIP)**
  - [ ] Landing page
  - [ ] Calendar view
  - [ ] Rides list
  - [ ] Responsive mobile-friendly UI
- **Backend (WIP)**
  - [ ] Compiled Info
    - [ ] Traffic times/estimate
    - [x] ATL TSA wait times
    - [ ] Uber/Lyft price estimates
    - [ ] Emory Transportation (Transloc)
  - [ ] Rideshare Info
    - [ ] Email sign-on
    - [ ] Ride filters
    - [ ] Adding rides through website
- **Bot (WIP)**
  - [ ] GroupMe scraping
  - [ ] GroupMe commands
  - [ ] DM messaging
  - [ ] GroupMe/email user connection and preferences

## Docs

For more specific information on each component, see their respective READMEs (located in their respective directories)

### File Structure

RIDEmory

- `backend`

  - `src/main/`

    - `java/com/projectpanas/ridemory` (API source code)
      - `config` (Spring Boot configuration files)
      - `repositories` (MongoDB related files)
      - `controllers`, `models`, `services` (self explanatory, review MVC components)
      - The only loose files in this folder should be `RidemoryApplication.java` and related files that don't fit in any of the other folders
    - `resources`
      - `static`, `templates` (static resources such as html files go here, we likely will never use this)
      - `application.properties` (general configurations for Spring Boot go here)
      - `secrets.properties` (secrets used by the backend go here and are imported as environment variables - _DO NOT COMMIT THESE!_)

  - `src/test/java/com/projectpandas/ridemory` (tests for code)

- `bot` (still in development, will be updated as project grows)

- `frontend`
  - `public` (assets not used during compilation such as favicons)
  - `src` (everything used during compilation)
    - `api` (code controlling backend communication)
    - `assets` (assets used during compilation and related exports and styling)
    - `tests` (tests for various components)
    - `components`, `pages` (self explanatory, review React, react-router-dom, components, and pages)
    - There shouldn't be other loose files aside from ones necessary for React to function (such as `App.jsx` or `index.jsx`) here - chances are, any new files could and should go into one of the aforementioned folders

### Setup & Testing

See each component's README for specific instructions on running and debugging its code. Note that a working `git` installation is assumed.

## Miscellaneous

Made with ❤️ by the Project Pandas, ©️ Project Emory 2023 under the ⚖️ GNU GPL-3.0 license
