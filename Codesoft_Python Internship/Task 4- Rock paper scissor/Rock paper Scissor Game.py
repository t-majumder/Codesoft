#Rock paper scissor game by Tamal Majumder

import random

print("::: ROCK PAPER SCISSOR :::")
print("\n:: I N S T R U C T I O N ::")
print("Inputs: \n For rock - R \n For paper - P \n For scissor - S\n ")

m=int(input("Input No of matches to decide the winner: "))

#To Count the score: 
c_h=0  #c_h=count for Human
c_c=0  #c_c=count for Computer 

for i in range(m):
    a=input("\nEnter your choice player: ")
    
    b="RPS"
    choice=random.choice(b)
    print("Computers Choice: ",choice)

    if (a==choice):
        c_h = c_h + 0
        c_c = c_c + 0

    #Logic for rock
    elif (a=='R' and choice=='P'):
        c_h = c_h + 0
        c_c = c_c + 1
    elif (a=='R' and choice=='S'):
        c_h = c_h + 1
        c_c = c_c + 0

    #Logic for paper
    elif (a=='P' and choice=='R'):
        c_h = c_h + 1
        c_c = c_c + 0
    elif (a=='P' and choice=='S'):
        c_h = c_h + 0
        c_c = c_c + 1

    #Logic for Scissor
    elif (a=='S' and choice=='R'):
        c_h = c_h + 0
        c_c = c_c + 1
    elif (a=='S' and choice=='P'):
        c_h = c_h + 1
        c_c = c_c + 0

    print("Human: ",c_h, "          Computer: ",c_c)
    
print ("\n\nFinal Score: ", "   Human: ",c_h, "          Computer: ",c_c )

if (c_h>c_c):
    print("\nHuman You are Unbeatable...")
elif (c_h<c_c):
    print("\n Hu HU Ha HA Ha Computer won . Now its time for us to take over...")
else:
    print("\nThe match is draw...")


        
        
