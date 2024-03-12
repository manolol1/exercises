import random
import os

# clear console window (from https://stackoverflow.com/questions/2084508/clear-terminal-in-python)
def clear(): os.system('cls' if os.name == 'nt' else 'clear')

while True:
    computer_selection = random.randint(1,3)

    clear()

    print("Let's play a game of Rock, Paper, Scissors!")
    print("What do you want to show?")
    print("1. Rock")
    print("2. Paper")
    print("3. Scissors")
    print("4. End Game\n")
    user_selection = int(input("Enter your choice: "))
    print("\n\n**********************\n")
    
    inputComplete = True

    if user_selection == 1: print("You show: Rock")
    elif user_selection == 2: print("You show: Paper")
    elif user_selection == 3: print("You show: Scissors")
    elif user_selection == 4:
        print("\nGame Ended.")
        break
    else: 
        print(user_selection, " is not a valid option. Please try again!")
        inputComplete = False

    if inputComplete:
        print("The Computer shows: ", end = "")
        if computer_selection == 1: print("Rock")
        elif computer_selection == 2: print("Paper")
        elif computer_selection == 3: print("Scissors")

        if user_selection == computer_selection: print("That's a draw!")

        if user_selection == 1 and computer_selection == 2: print("Paper beats Rock. You lost!")
        if user_selection == 2 and computer_selection == 1: print("Paper beats Rock. You won!")

        if user_selection == 3 and computer_selection == 1: print("Rock beats Scissors. You lost!")
        if user_selection == 1 and computer_selection == 3: print("Rock beats Scissors. You won!")

        if user_selection == 2 and computer_selection == 3: print("Scissors beats Paper. You lost!")
        if user_selection == 3 and computer_selection == 2: print("Scissors beats Paper. You won!")


    print("\n**********************\n\n")
    print("Press Enter to continue.")
    input()