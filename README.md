# Tic Tac Toe Game using JavaFX

Welcome to the Tic Tac Toe game project! This application allows you to play the classic game of Tic Tac Toe either with a friend offline or against the computer with different difficulty levels. The game is built using JavaFX and includes various features to enhance your gaming experience.

## Features

- **Multiplayer Mode**: Play with a friend offline.
- **Single Player Mode**: Play against the computer with three difficulty levels: Easy, Medium, and Hard.
- **Symbol Selection**: Choose your symbol (X or O) or let the computer choose randomly for you.
- **Sound Effects**: Enjoy background music, button click sounds, and win/lose sound effects.
- **Settings**: Mute the background music or exit the game from the settings window.
- **Random Turns**: Each new game starts with a random selection of who plays first (user or computer, X or O).

## Difficulty Levels

- **Easy**: The computer chooses any available square randomly.
- **Medium**: The computer prioritizes corner squares first, then the center, and finally any random available square.
- **Hard**: The computer employs a strategy to check for winning moves or block the user's winning moves, in addition to the Medium level strategy.

## How to Play

1. **Start the Game**: Launch the application and choose to play either with a friend or against the computer.
2. **Select Options**: Choose your symbol (X or O) or let the computer decide. Set the difficulty level if playing against the computer.
3. **Play the Game**: Follow the prompts to take turns placing your symbol on the grid.
4. **Win the Game**: The game will declare a winner when three of the same symbols align horizontally, vertically, or diagonally, or declare a draw if the grid is full with no winner.
5. **Adjust Settings**: Use the settings button to mute the background music or exit the game.

## Installation

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/tic-tac-toe-javafx.git
    cd tic-tac-toe-javafx
    ```

2. **Build the Project**: Open the project in your preferred Java IDE and build it using JavaFX libraries.

3. **Run the Application**: Execute the main class to start the game.

## Project Structure

- `src/`
  - `default package/`
    - `Settings-icon-symbol.png` - Settings icon.
    - `finalBackground.gif` - Final background image.
    - `greenBackground.jpg` - Green background image.
    - `offsound.png` - Off sound icon.
    - `onsound.png` - On sound icon.
    - `settingsback.jpg` - Settings background image.
    - `tic-tac-toe.png` - Tic Tac Toe logo.
  - `TicTacToe/`
    - `BoardPane.java` - Handles the game board UI.
    - `Buttons.java` - Manages button interactions.
    - `EasyBoard.java` - Easy level AI logic.
    - `GeneralBoard.java` - General game board logic.
    - `GeneralDesign.java` - General design elements.
    - `HardBoard.java` - Hard level AI logic.
    - `HardnessPane.java` - UI for selecting game hardness.
    - `Main.java` - The entry point of the application.
    - `MediumBoard.java` - Medium level AI logic.
    - `SettingsPane.java` - Handles the settings UI.
    - `StartPane.java` - Initial start screen UI.
    - `SymbolPane.java` - UI for selecting the player's symbol.
    - `musicButton.java` - Handles music button interactions.
    - `overallView.java` - Overall view management.
    - `settingsButton.java` - Handles settings button interactions.
    - `textStyle.java` - Manages text styles.

## Requirements

- Java 11 or higher
- JavaFX SDK

## Screenshots

Here are some screenshots of the game:

### Game Modes (Main Menu)
![Screenshot 2024-05-21 225213](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/ff650197-7c3a-4d22-b076-27e02fd0a6ab)

### Resizing the Window
![Screenshot 2024-05-21 225240](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/c6145a86-1590-45db-826e-1bcc7ce450f9)

### Playing Against a Friend
![Screenshot 2024-05-21 225254](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/d67b8121-67da-4787-b3ba-51e8ca12c26c)
![Screenshot 2024-05-21 225310](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/823c2fcb-2dfc-420d-97eb-7e6fe77d8da4)

### Settings Window
![Screenshot 2024-05-21 225324](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/116e60de-ebca-4304-a8b3-0e78220a0316)

### Difficulty Selection
![Screenshot 2024-05-21 225436](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/71d29b60-8271-451d-9bd1-90782fc87896)

### Symbol Selection
![Screenshot 2024-05-21 225448](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/fc72f25d-f47a-4d0d-9378-efc3621090b6)

### Playing Against the Computer
![Screenshot 2024-05-21 225522](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/2b14c3c7-2d35-46df-9731-112515e6ebc3)
![Screenshot 2024-05-21 225606](https://github.com/Sandyy44/Tic-Tac-Toe/assets/100297367/50daab93-e667-49ce-a281-dcd757d3711a)

## Contributions

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or new features.

---

Enjoy playing Tic Tac Toe and have fun enhancing your JavaFX skills with this project!
