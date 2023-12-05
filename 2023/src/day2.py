import functools


def play_one_star(game):
    gems = {'red' : 12, 'green' : 13, 'blue': 14}
    for turn in game:
        for color in turn.keys(): 
            if(gems[color] < turn[color]):
                return False
    return True

def play_second_star(game):
    smallest_set = {'red': 0,'blue': 0,'green': 0}
    for turn in game:
        for color in turn.keys():
            if turn[color] > smallest_set[color]:
                smallest_set[color] = turn[color]
    return functools.reduce(lambda a,b: a*b, smallest_set.values())
        

def merge_dictionary(d1, d2):
    for key in d2.keys():
        if(key in d1.keys()):
            d1[key] = d1[key] + d2[key]
        else:
            d1[key] = d2[key]
    return d1

def parse_turn(turn):
    first_split = turn.split(";")
    second_split = [i.split(",") for i in first_split]

    third_split = []
    for sublist in second_split:
        third_split.append(list({item.split( )[1] : int(item.split( )[0])} for item in sublist))

    merge = [functools.reduce(merge_dictionary, i) for i in third_split]
    return merge



f = open("../resources/day2.input", "r")

input = f.read().split("\n")
input.pop()

input = [i.split(":") for i in input]

for i in input:
    i[0] = int(i[0].split( )[1])
    #i[1] = play_one_star(parse_turn(i[1]))
    i[1] = play_second_star(parse_turn(i[1]))

#final = [item[0] for item in list(filter(lambda a: a[1], input))]
final = [item[1] for item in input]

print(functools.reduce(lambda a,b: a+b, final))


print(input)
