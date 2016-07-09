def verb_post(verb):
    irregular_verbs = {"write": "wrote", "go": "went", "put": "put", "be": "was", "do": "did", "eat": "ate"}
    p_verb = irregular_verbs.get(verb)
    x_alp = ["a", "e", "i", "o", "u"]
    if not p_verb:
        if verb.endswith("c"):
            p_verb = verb + "ked"
        elif verb.endswith("e"):
            p_verb = verb + "d"
        elif verb.endswith("y") and not verb[-2] in x_alp:
            p_verb = verb[0:len(verb) - 1] + "ied"
        else:
            p_verb = verb + "ed"
    return p_verb

print(verb_post("play"))
print(verb_post("like"))
print(verb_post("try"))
print(verb_post("picnic"))
print(verb_post("write"))
print(verb_post("go"))
print(verb_post("put"))
print(verb_post("be"))
print(verb_post("do"))
print(verb_post("eat"))
