"""
Alyssa Milinkovich
File: guessinggame.py
Sets up the player box and input text screen
"""
import random
from breezypythongui import EasyFrame
from file import File


class GuessingGame(EasyFrame):
    """Plays a guessing game with the user."""

    def __init__(self):
        """Sets up the window. and words"""

        self.words = ['cars', 'grape', 'hammer', 'place', 'plates']
        
        EasyFrame.__init__(self, title = "Word Scramble Guessing Game")
        self.guessCount = 0
        greeting = "Guess the word!"
        self.textLabel = self.addLabel(text=greeting,
                                       row=0, column=0,
                                       sticky="NSEW",
                                       columnspan=2)
        self.addLabel(text="Player guess", row=1, column=0)
        self.playerGuess = self.addTextField("", row=1, column=1)
        self.addLabel(text="Word Scramble", row=2, column=0)
        self.wordScramble = self.addTextField("", row=2, column=1, state="readonly")
        self.nextButton = self.addButton(text="Submit", row=3, column=0,
                                         command=self.nextGuess)
        self.newButton = self.addButton(text="Reset game", row=3, column=1,
                                        command=self.resetGame)

        self.scrambledWord(random.choice(self.words))

    def scrambledWord(self, word):
        """Inputs scrambled word onto screen"""
        self.current_word = word  
        scramble = ''.join(random.sample(word, len(word)))
        self.wordScramble.setText(scramble)

        
    def nextGuess(self):
        """User's guess."""
        self.guessCount += 1
        guess = self.playerGuess.getText().strip()         
  
        correct_word = self.wordScramble.getText()

        if guess.lower() == self.current_word.lower():
            self.textLabel["text"] = "You did it!"
            self.nextButton["state"] = "disabled"
          
            File().writeFile(guess, self.guessCount)
        else:
            self.textLabel["text"] = "That is incorrect!"


    def resetGame(self):
        """Resets the game"""
        self.guessCount = 0
        greeting = "Guess the word from the scramble"
        self.textLabel["text"] = greeting
        self.nextButton["state"] = "normal"
        self.playerGuess.setText("")
        self.scrambledWord(random.choice(self.words))


        
        
        
