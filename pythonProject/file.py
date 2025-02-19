"""
Alyssa Milinkovich
File: file.py
Imports a message from a file then prints all of the players guesses to the file
My add is a popup message before the game starts.
"""

import tkinter.filedialog
from tkinter import *
from tkinter import messagebox


class File(object):

    def __init__(self):
        file = open("textfile.txt", 'r')

    def beginPopUpMessage(self):
        """Adds a popup message before the game begins. This is my concept
we didnt learn in class"""
        Tk().wm_withdraw()
        messagebox.showinfo('Welcome to our game!','Lets start')
 


    def openFile(self):
       """ Opens a file """
       with open("textfile.txt", 'r') as file:
            for line in file:
                print(line)
     

    def writeFile(self, player_guess, guess_count):
        """  Writes in a file """
        with open("textfile.txt", 'w') as fileObj:
            fileObj.write(f"Player guess: {player_guess}\n")
            fileObj.write(f"Guess count: {guess_count}\n")
