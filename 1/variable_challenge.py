a = input("a: ")
b = input("b: ")

temporaryB = b
b = a
a = temporaryB

print("a = " + a)
print("b = " + b)