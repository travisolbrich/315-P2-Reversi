Design Document
===============

## Purpose of Project

The goal is to create a Reversi game. This game will focus on an audience interested in strategy board games. Throughout the project, experience will then be gained in both AI algorithms as well as Server-Client programming. Finally, designing a high-quality GUI for the game will be the final step in the game's progression. The game will follow traditional Reversi rules found on the [Reversi wiki page](http://en.wikipedia.org/wiki/Reversi) as referenced by the [Project Instructions](http://courses.cs.tamu.edu/choe/13fall/315/proj2.html).

## High Level Entities

The three main entities are the Server, Client and Game loop. 

The server will be the entry point for clients. They will be placed into a lobby and the game will begin once they user has selected their preferred settings.

The lobbies are run in separate, contained threads that handle creating and running the game's logic.

The game runs in a simple loop that uses several controller components that handle input, updating, and scoring.


## Low Level Entities

While the server class handles connecting clients, a Lobby Controller is used for figuring out what Lobby to place a player into. 
For singleplayer Reversi game, this means creating a new Lobby and placing the user into that lobby. For a multiplayer Reversi game, the controller spawns a small task to take the user's input for the lobby they want to join.

![Reversi Logic Design](img/GameLogicDiagram.png)

The Lobby Controller is run on a separate thread to keep the server from locking up while waiting for user input for multiplayer games, but for singleplayer the clients are sent to a new Lobby. 
Created lobbies are given a GameFactory instance that allows them to create a gameboard using the Lobby settings.

Once all players are ready, the game will begin and the GameFactory delegate is used for creating a new game. The newly created ReversiGame is run in the same loop as the lobby.
First a new board is created by the BoardController, then the main gameloop begins which cycles first to the PlayerController to update the score. 
The InputController follows, and is used to retrieve Input from players; in Reversi, this means a single player per turn. The InputController uses two delegates to handle human and AI input.
The TurnController comes last, updating the board and players using the Input created from the InputController. The TurnController is responsible for handling the Undo function as well, so the ReversiTurnController will capture all ReversiTokens for the last several turns in a single-linked list.

![Server Client Design](img/ServerClientDiagram.png)

Once the game ends or the player(s) want to end/restart their game, control will return to the lobby loop. 

## Benefits, Assumptions, and Risks

Benefits 
Highly modular design that allows for easy implementation of different AI's, rules, and even games. 