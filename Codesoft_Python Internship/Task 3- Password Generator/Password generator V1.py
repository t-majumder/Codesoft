#Random Password Generator by Tamal Majumder
import random

print("::: P A S S W O R D   G E N E R A T O R  V 1.0 :::")

chars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYS@%#1234567890"

while 1:
    password_len= int(input("\n* What length would you like your password to be: "))
    password_count=int(input("* How many password would you like to generate: "))

    for x in range(0,password_count):
        password= ""
        
        for x in range(0,password_len):
            password_char=random.choice(chars)
            password= password+password_char
        print("\nHere is your password :",password)
