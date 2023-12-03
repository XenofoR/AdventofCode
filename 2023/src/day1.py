import functools 


def add_together(x):
    if(len(x) == 0):
        return 0
    first = x[0]
    last = x[len(x)-1]
    if(not first.isnumeric()):
        first = last
    elif(not last.isnumeric()):
        last = first
    
    return first + last

def is_numeric(x):
    return x.isnumeric()


file = open("../resources/day1.input", "r")
input = file.read().split("\n")


numbers = [list(filter(is_numeric, i)) for i in input]


addition = list(map(add_together, numbers))

print(functools.reduce(lambda a,b: a+b, [int(i) for i in addition]))

