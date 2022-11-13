name = input("What is your name? : ")

count = len(name)
displayText = "Your namme includes " + str(len(name)) + " character"

if count > 1 or count < 1:
    print(displayText + "s")
else:
    print(displayText)

# print("Your namme includes " + str(len(name)) + " characters")

print( len( input("What is your name? ")))