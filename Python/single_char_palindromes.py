def now_is_a_pallindrom(s, idx_debut, idx_fin):
    if idx_debut >= idx_fin:
        return True
    if s[idx_debut] != s[idx_fin]:
        return False
    else:
        return now_is_a_pallindrom(s, idx_debut + 1, idx_fin -1)


def is_a_pallindrom_maybe_minus_one(s, idx_debut, idx_fin):
    if s:
        if idx_debut >= idx_fin:
            return "OK"
        if s[idx_debut] != s[idx_fin]:
            if now_is_a_pallindrom(s[:idx_debut]+s[idx_debut+1:], 0, len(s)-2)or \
                    now_is_a_pallindrom(s[:idx_fin]+ s[idx_fin+1:], 0, len(s)-2):
                return "remove one"
            else:
                return "not possible"
        else:
            return is_a_pallindrom_maybe_minus_one(s, idx_debut + 1, idx_fin -1)
    return "not possible"

def solve(s):
    return is_a_pallindrom_maybe_minus_one(s, 0, len(s)-1)