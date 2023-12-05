import functools 


def add_together(x):
    if(len(x) == 0):
        return 0
    return x[0] + x[-1]

def is_numeric(x):
    return x.isnumeric()


file = open("../resources/day1.input", "r")
input = file.read().split("\n")


numbers = [list(filter(is_numeric, i)) for i in input]


addition = list(map(add_together, numbers))

print(functools.reduce(lambda a,b: a+b, [int(i) for i in addition]))

