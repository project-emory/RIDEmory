# RIDEmory 🚙

A self-updating database of ride information for Emory students accessible via the web or GroupMe.

Currently WIP, watch the repository and check back for updates!

## Table of Contents

- [Vision](#vision)
  - [Design](#design)
  - [Features](#features)
- [Docs](#docs)
  - [File Structure](#file-structure)
  - [Setup](#setup)
  - [Best Practice](#best-practice)
  - [Testing](#testing)
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
  - [ ] Cohesive, user friendly design
  - [ ] Landing page
  - [ ] Calendar view
  - [ ] Rides list
  - [ ] Watch for rides at a specific time
  - [ ] Create a ride request
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

### Setup

See each component's README for specific instructions on setting up its code. This section will be covering general environment setup.

For the sake of debugging issues and normalizing the development process across the board, this project will use [VS Code](https://code.visualstudio.com/) as the IDE of choice due to its flexibility and customizability. Feel free to use whatever IDE you are comfortable with - however, I cannot guarantee I can help you with installation or set up.

Firstly, download and install VS Code. Once you have that installed, also install [git](https://git-scm.com/downloads) (for Windows, use the installer; for MacOS, install Xcode; for Linux, check if you already have it installed before using your package manager) and check if it was installed properly by typing in `git --version` to a new terminal window. Restart VS Code if it is running.

Copy this repository's web URL (https://github.com/PROJECT-Emory-2023/RIDEmory.git), and on the new VS Code window, click the "Clone Git Repository..." option and paste the link in the box that pops up, placing the project folder in your desired location (one option would be `~/Documents/Projects`). Open the folder, and you now have the code locally! When you end up trying to push code to the repository on GitHub, you may need to provide git credentials.

If you happen to need credentials, you will have to create a personal access token on GitHub; go to [Settings > Developer Settings > Tokens > New Personal Access Token](https://github.com/settings/tokens/new) (or just click on the link), change the note to something like "personal-laptop-access," set the expiration (no expiration is most convenient, just make sure you do not share this with anyone), click on the "repo" scope, and finally generate your token. Copy this and make sure you save it somewhere, and when you are next asked to set your git password, paste this key in place of your GitHub password.

There are a few extensions that will make your life easier, so I would recommend installing them (you can just copy and paste the ID in paranthesis into the extensions search bar in VS Code).

- Backend
  - Extension Pack for Java (`vscjava.vscode-java-pack`)
  - Spring Boot Extension Pack (`vmware.vscode-boot-dev-pack`)
- Bot
  - Python (`ms-python.python`)
  - Pylance (`ms-python.vscode-pylance`)
- Frontend
  - Mithril Emmet (`FallenMax.mithril-emmet`)
  - ES7+ React snippets (`dsznajder.es7-react-js-snippets`)

And that should be it! If at any point you have questions or run into difficulty (perhaps because I forgot something), reach out for help.

### Best Practice

Just remember a few things while working on RIDEmory:

1. Edit code in a new branch to avoid conflicts by checking out a new branch on the "Source Control" tab of VS Code, naming it `username/feature`. Make sure to publish it - it is now your branch and you have free reign over what you do in it (within reason :)).
2. Please don't force add any ignored files, as they may contain secrets such as keys and passwords. If you add a new file with secrets, add it to the relevant `.gitignore` file and make a note when you create a pull request.
3. Don't be afraid to reach out your project leads and other team members are here to support you, so shoot a message in the slack if you have any questions.

### Testing

See each component's README for specific instructions on running and debugging its code.

## Miscellaneous

Made with ❤️ by the Project Pandas, ©️ Project Emory 2023 under the ⚖️ GNU GPL-3.0 license
