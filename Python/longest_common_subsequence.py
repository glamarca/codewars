def lcs(string, seq):
    result = ""
    if string and seq:
        z = [s for s in seq if s in string]
        for s in seq:
            if s in string:
                string = string.replace(s, "")
                result += s
    return result
